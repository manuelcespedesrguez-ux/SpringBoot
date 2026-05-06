package com.cebem.demo.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RestController;

import com.cebem.demo.models.PixelModel;
import com.cebem.demo.services.PixelService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/pixels")
@RequiredArgsConstructor
public class PixelController {
    
    private final PixelService pixelService;

    @GetMapping //("/pixels")
    public ArrayList<PixelModel> getAllPixels(){
        return pixelService.getAllPixels();
    }


    @PostMapping // ("/pixels")
    public PixelModel savePixel(@RequestBody PixelModel pixel){
        return pixelService.savePixel(pixel);
    }
}