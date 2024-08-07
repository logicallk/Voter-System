package com.VotingSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VotingSystem.entity.Election;
import com.VotingSystem.repository.ElectionRepo;

@Service
public class ElectionServicesImplement implements ElectionServices{

	@Autowired
	ElectionRepo electionRepol;
	@Override
	public void saveElection(Election election) {
		// TODO Auto-generated method stub
		electionRepol.save(election);
		
		
	}

	@Override
	public List<Election> allElections() {
		// TODO Auto-generated method stub
		List<Election> elections= electionRepol.findAll();
		
		
		return elections;
	}

	@Override
	public List<Election> upComingElections() {
		// TODO Auto-generated method stub
		List<Election> elections= electionRepol.findAll();
		List<Election> upcoming=new ArrayList<>();
		LocalDate currentdate=LocalDate.now();
		for(Election e:elections)
		{
			if(currentdate.isBefore(e.getEstartdate()) || currentdate.isEqual(e.getEstartdate()))
			{
				upcoming.add(e);
			}
		}
		return upcoming;
	}

}
