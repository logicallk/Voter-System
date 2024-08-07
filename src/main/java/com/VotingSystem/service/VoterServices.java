package com.VotingSystem.service;

import java.util.List;

import com.VotingSystem.entity.Voter;

public interface VoterServices  {

	public void addVoter(Voter voter);
	public List<Voter> getAllVoter();
	public Voter getOneVoter(int vid);
	public void deleteVoter(int vid);
	public void updateVoter(Voter voter);
}
