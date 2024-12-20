package com.example.demo.graphic_texture.repository;

import com.example.demo.graphic_texture.entity.GraphicTexture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GraphicTextureRepository extends JpaRepository<GraphicTexture, Long> {

    @Query("SELECT COUNT(gt) FROM GraphicTexture gt")
    long countAllGraphicTextures();

    Optional<GraphicTexture> findByCardNumber(int cardNumber);
}
