package com.example.picture_api.image.response;

public class ImageResponse {

    private Long id;
    private String name;
    private String url;

    public ImageResponse(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    // getters and setters
}
