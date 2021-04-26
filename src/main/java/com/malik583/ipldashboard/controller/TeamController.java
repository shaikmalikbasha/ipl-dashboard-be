package com.malik583.ipldashboard.controller;

import com.malik583.ipldashboard.model.Team;
import com.malik583.ipldashboard.repository.MatchRepository;
import com.malik583.ipldashboard.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "")
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public List<Team> getTeams() {
        return this.teamRepository.findAll();
    }

    @RequestMapping(value = "/team/{teamName}", method = RequestMethod.GET)
    public Team getTeam(@PathVariable String teamName) {
        Team team = this.teamRepository.findByTeamName(teamName);
        team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamName, 4));
        
        return team;
    }
}
