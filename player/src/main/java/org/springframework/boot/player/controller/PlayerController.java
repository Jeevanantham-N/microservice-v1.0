package org.springframework.boot.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.player.model.Player;
import org.springframework.boot.player.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }
        
    @GetMapping("/{player_id}")
    public ResponseEntity<Player> getPlayer(@PathVariable(name="player_id") Long playerID){
        Player player = playerService.getPlayer(playerID);
        return player != null ? new ResponseEntity<>(player, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
            
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player nPlayer = playerService.addPlayer(player);        
        return new ResponseEntity<>(nPlayer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{player_id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable(name="player_id") Long playerID){
        playerService.deletePlayer(playerID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player nPlayer = playerService.updatePlayer(player);
        return new ResponseEntity<>(nPlayer, HttpStatus.CREATED);
    }

}
