package com.so.spring.relation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    @Query("select p from Player p where p.team.teamId = :teamId")
    List<Player> findAllByTeam_TeamId(@Param("teamId") long teamId);
}
