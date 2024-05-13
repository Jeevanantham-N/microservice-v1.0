package org.springframework.boot.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.team.model.Team;
import org.springframework.boot.team.service.TeamService;
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
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;
    
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams(){
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }
        
    @GetMapping("/{team_name}")
    public ResponseEntity<Team> getTeam(@PathVariable(name="team_name") String teamName){
        Team team = teamService.getTeam(teamName);
        return team != null ? new ResponseEntity<>(team, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
            
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team){
        Team nTeam = teamService.createTeam(team);        
        return new ResponseEntity<>(nTeam, HttpStatus.CREATED);
    }

    @DeleteMapping("/{team_name}")
    public ResponseEntity<Team> deleteTeam(@PathVariable(name="team_name") String teamName){
        teamService.deleteTeam(teamName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Team> updateTeam(@RequestBody Team team){
        Team nTeam = teamService.updateTeam(team);
        return new ResponseEntity<>(nTeam, HttpStatus.CREATED);
    }

}
