package com.VotingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VotingSystem.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{

}
