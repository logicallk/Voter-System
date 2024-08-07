package com.VotingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VotingSystem.entity.Admin;
import com.VotingSystem.repository.AdminRepo;

@Service
public class AdminServiceImplement implements AdminService {

	@Autowired
	AdminRepo adminRepo;

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminRepo.save(admin);
		
		
	}

	@Override
	public List<Admin> adminlist() {
		// TODO Auto-generated method stub
		List<Admin> find=adminRepo.findAll();
		return find;
	}

	@Override
	public Admin adminData(String username, String password) {
		// TODO Auto-generated method stub
		
		return null;
	}
}
