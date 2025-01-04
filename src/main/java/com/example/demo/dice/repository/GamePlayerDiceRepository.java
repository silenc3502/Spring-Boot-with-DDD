package com.example.demo.dice.repository;

import com.example.demo.dice.entity.GamePlayerDice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GamePlayerDiceRepository extends JpaRepository<GamePlayerDice, Long> {

    @Query("SELECT gpd FROM GamePlayerDice gpd JOIN FETCH gpd.player WHERE gpd.game.id = :gameId")
    List<GamePlayerDice> findByGameIdWithPlayer(@Param("gameId") Long gameId);

//    @Query("SELECT gpd.player.id, SUM(d.number) " +
//            "FROM GamePlayerDice gpd " +
//            "JOIN gpd.dice d " +
//            "WHERE gpd.game.id = :gameId " +
//            "GROUP BY gpd.player.id")
//    List<Object[]> findPlayerScoresByGameId(@Param("gameId") Long gameId);

    @Query("SELECT gpd.player.id, SUM(dice.number) " +
            "FROM GamePlayerDice gpd " +
            "JOIN gpd.dice dice " +
            "WHERE gpd.game.id = :gameId " +
            "GROUP BY gpd.player.id")
    List<Object[]> findPlayerScoresByGameId(@Param("gameId") Long gameId);
}
