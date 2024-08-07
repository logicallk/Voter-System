package com.VotingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VotingSystem.entity.Voter;
import com.VotingSystem.repository.VoterRepo;

@Service
public class VoterServicesImplement implements VoterServices{

	@Autowired
	VoterRepo voterRepo;
	@Override
	public void addVoter(Voter voter) {
		voterRepo.save(voter);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Voter> getAllVoter() {
		// TODO Auto-generated method stub
		List<Voter> voters=voterRepo.findAll();
		return voters;
	}

	@Override
	public void deleteVoter(int vid) {
		// TODO Auto-generated method stub
		
		voterRepo.deleteById(vid);
		
		
	}

	@Override
	public void updateVoter(Voter voter) {
		// TODO Auto-generated method stub
		voterRepo.save(voter); 
		
	}

	@Override
	public Voter getOneVoter(int vid) {
		// TODO Auto-generated method stub
		Voter voter=voterRepo.getById(vid);
		return voter;
	}
	

	
}
