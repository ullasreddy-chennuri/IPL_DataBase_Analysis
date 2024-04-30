package com.dmqlproject.Backend.Service;

import com.dmqlproject.Backend.Model.PlayerStatistics;
import com.dmqlproject.Backend.Repository.PlayerStatisticsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatisticsService {
    @Autowired
    public PlayerStatisticsRepo repo;

    public List<PlayerStatistics> findall(){
        return repo.findAll();
    }

    public PlayerStatistics search(String keyword) {
        return repo.findByNameoftheplayer(keyword);
    }

    public List<PlayerStatistics> searchByName(String keyword) {
        return repo.findByNameoftheplayerContaining(keyword);
    }

    public PlayerStatistics searchByID(Integer keyword) {
        return repo.findByPlayerId(keyword);
    }

//    public List<PlayerStatistics> searchByTerm(String keyword) {
//        return repo.findByPlayerNameContaining(keyword);
//    }
}
