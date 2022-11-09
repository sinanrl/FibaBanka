package com.so.spring.relation.mvc;

import com.so.spring.relation.Player;
import com.so.spring.relation.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/byteam")
    @ResponseBody
    public String getPlayersByTeam() {
        long teamId = 1;
        List<Player> players = playerRepository.findAllByTeam_TeamId(teamId);
        return "Players: " + 1;
    }
}
