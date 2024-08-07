package com.VotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VotingSystem.entity.Election;

@Repository
public interface ElectionRepo extends JpaRepository<Election, Integer>{

}
