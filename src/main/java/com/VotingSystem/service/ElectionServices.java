package com.VotingSystem.service;

import java.util.List;

import com.VotingSystem.entity.Election;

public interface ElectionServices {

	public void saveElection(Election election);
	public List<Election> allElections();
	public List<Election> upComingElections();
}
