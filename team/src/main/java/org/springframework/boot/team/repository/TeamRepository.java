package org.springframework.boot.team.repository;

import org.springframework.boot.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, String>{

    @Query("SELECT t FROM Team t WHERE t.teamName = :teamName")
    Team findByTeamName(String teamName);

    @Modifying
    @Query("DELETE FROM Team t WHERE t.teamName = :teamName")
    int deleteByTeamName(String teamName);

}
