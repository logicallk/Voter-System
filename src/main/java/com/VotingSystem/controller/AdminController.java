package com.VotingSystem.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.VotingSystem.entity.Admin;
import com.VotingSystem.entity.Election;
import com.VotingSystem.entity.Voter;
import com.VotingSystem.repository.AdminRepo;
import com.VotingSystem.service.AdminService;
import com.VotingSystem.service.AdminServiceImplement;
import com.VotingSystem.service.ElectionServicesImplement;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AdminController {

	@Autowired
	AdminRepo adminRepo;
	@Autowired
	AdminServiceImplement adminService;
	@Autowired
	ElectionServicesImplement electionServicesImplement;
	
	@GetMapping("/")
	public String startPage()
	{
		return "startpage";
	}
	@GetMapping("/admindashbord")
	public String openAdminDashboard()
	{
		return "admindashbord";
	}
	  @GetMapping("/adminregisterform")
	    public String showRegisterForm(Model model) {
	        model.addAttribute("admin", new Admin());
	        return "adminregister";
	    }

	    @PostMapping("/saveAdmin")
	    public String saveAdmin(@Valid @ModelAttribute Admin admin, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            return "adminregister";
	        }
	        
	        adminService.saveAdmin(admin);
	        return "adminlogin";
	    }
	    
	    @PostMapping("/loginAdmin")
	    public String loginAdmin(@RequestParam("username") String Username,@RequestParam("password") String Password)
	    {
	    	 Admin admin= adminRepo.getById(Username);
	    	
	    	 
	    		if(admin.getUsername().equals(Username) && admin.getPassword().equals(Password))
	    		{
	    			return "admindashbord";
	    		}
	    	
	    	
	    	return "adminlogin";
	    }
	    
	    @GetMapping("/adminlogin")
	    public String adminLoginPage()
	    {
	    	return "adminlogin";
	    }
	    
	   @GetMapping("/addelectionform")
	   public String openAddElection(Model model)
	   {
		   model.addAttribute("election", new Election());
		   return "addelection";
	   }
	   
	   @PostMapping("/addelection")
		  public String addElection(@ModelAttribute Election election)
		  {
			  
			  electionServicesImplement.saveElection(election);
			  return "admindashbord";
		  }
	   
	   @GetMapping("/viewelectionpage")
	   public String viewElectionPage(Model model)
	   {
		   List<Election> elections=electionServicesImplement.allElections();
		   model.addAttribute("elections",elections);
		   return "viewelectionatadmin";
	   }
	    
	 
	   
}
