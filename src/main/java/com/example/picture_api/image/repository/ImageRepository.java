package com.example.picture_api.image.repository;

import java.awt.Image;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.picture_api.image.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
