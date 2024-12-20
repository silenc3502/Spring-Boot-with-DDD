package com.example.demo.card.repository;

import com.example.demo.card.entity.CardDamage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDamageRepository extends JpaRepository<CardDamage, Long> {
}
