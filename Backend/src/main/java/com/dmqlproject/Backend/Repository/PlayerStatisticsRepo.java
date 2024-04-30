package com.dmqlproject.Backend.Repository;

import com.dmqlproject.Backend.Model.PlayerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerStatisticsRepo extends JpaRepository<PlayerStatistics, Integer> {
//    List<PlayerStatistics> findByName(String name);
    //List<PlayerStatistics> findByPlayerNameContaining(String keyword);

    List<PlayerStatistics> findByNameoftheplayerContaining(String keyword);

    PlayerStatistics findByNameoftheplayer(String keyword);

    PlayerStatistics findByPlayerId(Integer keyword);
}