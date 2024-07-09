package com.example.picture_api.image.controller;

import java.awt.Image;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.picture_api.image.entity.Image;
import com.example.picture_api.image.domain.ImageService;

import com.example.picture_api.image.response.ImageResponse;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<ImageResponse> getAllImages() {
        return imageService.getAllImages().stream()
                .map(image -> new ImageResponse(image.getId(), image.getName(), "/api/images/" + image.getId()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Void> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.saveImage(file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            return ResponseEntity.ok().body(image.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
