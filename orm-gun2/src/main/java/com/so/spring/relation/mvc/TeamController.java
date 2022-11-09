package com.so.spring.relation.mvc;

import com.so.spring.relation.Player;
import com.so.spring.relation.Team;
import com.so.spring.relation.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sports")
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/team/insert")
    @ResponseBody
    public String insertTeam() {
        Team teamA = new Team(0, "Sinan spor");
        teamA.setPlayerList(List.of(
                new Player(0, "Sinan1", 100, teamA),
                new Player(0, "Sinan2", 99, teamA),
                new Player(0, "Sinan3", 98, teamA)));

        teamRepository.save(teamA);

        return "Team oluşturuldu";
    }
}
