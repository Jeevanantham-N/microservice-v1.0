package org.springframework.boot.player.repository;

import org.springframework.boot.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlayerRepository extends JpaRepository<Player, Long>{

}
