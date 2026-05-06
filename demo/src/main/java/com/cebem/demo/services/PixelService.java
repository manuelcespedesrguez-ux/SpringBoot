package com.cebem.demo.services;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.cebem.demo.models.PixelModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PixelService {
    // Inyeccíón de dependencias
    private final StringRedisTemplate redis;
    /*
     * public PixelService(StringRedisTemplate redis){
     * this.redis = redis;
     * }
     */

    public ArrayList<PixelModel> getAllPixels() {
        // Usando la libreria de redis, obtenemos todos los pixeles guardados en la BD
        ArrayList<PixelModel> pixels = new ArrayList<>();

        Set<String> claves = redis.keys("pixel:*");

        if(claves == null){
            return pixels;
        }

        for(String clave : claves){
            // get pixel:x:y  
            String color = redis.opsForValue().get(clave);
            String[] partes = clave.split(":");
            PixelModel pixel = new PixelModel( 
                Integer.parseInt(partes[1]), Integer.parseInt(partes[2]) , color );
            pixels.add(pixel);
        }
        return pixels;
    }

    public PixelModel savePixel(PixelModel pixel) {
        // set pixel:x:y color
        String clave = "pixel:" + pixel.getX() + ":" + pixel.getY();
        redis.opsForValue().set(clave, pixel.getColor());
        return pixel;
    }

}
