package com.VotingSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.VotingSystem.entity.Admin;
import com.VotingSystem.entity.Election;
import com.VotingSystem.entity.Voter;
import com.VotingSystem.repository.VoterRepo;
import com.VotingSystem.service.ElectionServicesImplement;
import com.VotingSystem.service.VoterServicesImplement;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class VoterController {

	@Autowired
	VoterRepo voterRepo;
	@Autowired
	VoterServicesImplement voterServicesImplement;
	
	@Autowired
	ElectionServicesImplement electionServicesImplement;
	
	@GetMapping("/voterloginform")
	public String voterloginpage()
	{
		return "voterlogin";
	}
	
	@GetMapping("/voterdashborad")
	public String openVoterDashboard()
	{
		return "voterdashborad";
	}
	@GetMapping("/login")
	public String loginVoter(@RequestParam("username") String Username,@RequestParam("password") String Password,HttpSession session)
	{
		List<Voter> voters=voterServicesImplement.getAllVoter();
		for(Voter v:voters)
		{
			if(v.getUsername().equals(Username) && v.getPassword().equals(Password))
			{
				session.setAttribute("vid", v.getVid());
				return "voterdashborad";
			}
		}
		return "voterlogin";
	}
	 @GetMapping("/addvoter")
	    public String addVoterPage(Model model)
	    {
		 model.addAttribute("voter",new Voter());
	    	return "addvoter";
	    }
	 
	 
	 
	  @PostMapping("/saveVoter")
	    public String saveAdmin(@Valid @ModelAttribute Voter voter, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            return "addvoter";
	        }
	        System.out.println(voter.toString());
	        voterServicesImplement.addVoter(voter);
	        return "admindashbord";
	    }
	  
	  @GetMapping("/viewvoter")
	  public String viewVoterPage(Model model)
	  {
		  List<Voter> voters=voterServicesImplement.getAllVoter();
		  model.addAttribute("voters",voters);
		
		  return "viewvoter";
	  }
	  
	  @GetMapping("/delete/{vid}")
	  public String deleteVoter(@PathVariable int vid,RedirectAttributes redirectAttributes)
	  {
		  voterServicesImplement.deleteVoter(vid);
		  return "redirect:/viewvoter";
	  }
	  
	 
	  
	  @GetMapping("/filtervoter")
	    public String filterVoter(@RequestParam("district") String District,Model model)
	    {
	    	List<Voter> fitervoters=new ArrayList<>();
	    	List<Voter> voter=voterServicesImplement.getAllVoter();
	    	for(Voter v:voter)
	    	{
	    		if(v.getDistrict().equals(District))
	    		{
	    			fitervoters.add(v);
	    		}
	    	}
	    	model.addAttribute("voters",fitervoters);
	    	return "viewvoter";
	    }
	  
	  @GetMapping("/viewvoteratvoterdashboard")
	  public String viewVoterDetails(Model model,HttpSession session)
	  {
		  int vid= (int) session.getAttribute("vid");
		 
		 Voter voter= voterRepo.getById(vid);
		 
		 model.addAttribute("voter",voter);
		 return "viewvoteratvoterdashboard";
	  }
	  
	  @GetMapping("/updatevoterform")
	  public String openVoterUpdateForm(Model model,HttpSession session)
	  {
		  int vid=(int) session.getAttribute("vid");
		  Voter voter=voterRepo.getById(vid);
		  model.addAttribute("voter",voter);
		  return "updatevoterdetails";
	  }
	  
	  @PostMapping("/updateVoter")
	  public String updateVoter(@ModelAttribute Voter voter,HttpSession session)
	  {
		  voterRepo.save(voter);
		  
		  return "/viewvoteratvoterdashboard";
	  }
	  
	  @GetMapping("/viewelectionatvoter")
	  public String viewElectionDetailsAtVoter(Model model)
	  {
		  List<Election> upcomingElections=electionServicesImplement.upComingElections();
		  model.addAttribute("upcomingElections",upcomingElections);
		  return "viewelectionatvoter";
	  }
	
	    
}
