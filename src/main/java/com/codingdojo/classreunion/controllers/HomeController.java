package com.codingdojo.classreunion.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.classreunion.models.Idea;
import com.codingdojo.classreunion.services.ideaService;


@Controller
public class HomeController {

	@Autowired
	ideaService ideaServ;
	
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("ideas", 		ideaServ.allIdeas());
		
		return "dashboard.jsp";
	}
	
	
	// Renders the form to make an Idea
	@RequestMapping("/newIdea")
	public String newidea(@ModelAttribute("idea") Idea idea) {
		return "newIdea.jsp";
	}
	
	// Make a method to actually create an Idea
	@RequestMapping("/processIdea")
	public String processIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
		if(result.hasErrors()) {
			return "newIdea.jsp";
		}
		ideaServ.create(idea);
		return "redirect:/dashboard";
		
	}
	
	// To show one Idea
	@RequestMapping("/oneIdea/{id}")
	public String viewIdea(@PathVariable("id") Long id, 							Model model) {
		model.addAttribute("idea",       ideaServ.oneIdea(id));
		return "oneIdea.jsp";
	}
	
	
	// Render the form to edit an idea
	@RequestMapping("/editIdea/{id}")
	public String editIdea(@PathVariable("id") Long id, Model model) {
		Idea idea = ideaServ.oneIdea(id);
		model.addAttribute("idea", idea);
		return "editIdea.jsp";
	}
	
	// Method to actually Edit the idea
	@RequestMapping(value="/editIdea/{id}", method= 					RequestMethod.PUT)
	public String editingIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result) {
		if(result.hasErrors()) {
			return "editIdea.jsp";
		}
		else {
			ideaServ.updateIdea(idea);
			return "redirect:/dashboard";
		}
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteIdea(@PathVariable("id") Long id) {
		ideaServ.deleteIdea(id);
		return "redirect:/dashboard";
	}
	
}
