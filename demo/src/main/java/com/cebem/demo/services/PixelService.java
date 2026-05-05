package com.cebem.demo.services;

import java.util.ArrayList;

import java.util.Set;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.cebem.demo.models.PixelModel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PixelService {

    private final StringRedisTemplate redis;

    public ArrayList<PixelModel> getAllPixels(){
        ArrayList<PixelModel> pixels = new ArrayList<>();

        Set<String> claves = redis.keys("pixel:*");
        for (String clave : claves) {
            String valor = redis.opsForValue().get(clave);
            String[] partes = clave.split(":");
            PixelModel pixel = new PixelModel(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]), valor);
            pixels.add(pixel);
        }
        return pixels;
    }

    public PixelModel savePixel(PixelModel pixel){
        String clave = "pixel: "+pixel.getX() + ":" + pixel.getY();
        redis.opsForValue().set(clave, pixel.getColor());
        return pixel;
    }
}
