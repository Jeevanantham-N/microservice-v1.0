package org.springframework.boot.player.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.player.model.Player;
import org.springframework.boot.player.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(Long playerID) {
        return playerRepository.findById(playerID).get();
    }

    @Transactional
    public void deletePlayer(Long playerID) {
        playerRepository.deleteById(playerID);
    }

    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

}
