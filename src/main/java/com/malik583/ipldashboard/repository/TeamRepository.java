package com.malik583.ipldashboard.repository;

import com.malik583.ipldashboard.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findByTeamName(String teamName);

    List<Team> findAll();
}
