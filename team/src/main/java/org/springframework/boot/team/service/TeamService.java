package org.springframework.boot.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.team.model.Team;
import org.springframework.boot.team.repository.TeamRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeam(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }

    @Transactional
    public void deleteTeam(String teamName) {
        teamRepository.deleteByTeamName(teamName);
    }

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

}
