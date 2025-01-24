package ca.sheridancollege.patdixan.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.patdixan.beans.Ticket;
import ca.sheridancollege.patdixan.beans.User;
import ca.sheridancollege.patdixan.repositories.SecurityRepository;
import ca.sheridancollege.patdixan.repositories.TicketRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TicketController {
	
	private TicketRepository ticketRepo;
	private SecurityRepository secRepo;
	
	@GetMapping("/")
	public String rootToot() {
	return "root.html";
	}
	
	@GetMapping("/add")
	public String goAdd(Model model) {
		model.addAttribute("ticket", new Ticket());
		 List<User> userList = secRepo.getAllUsers();
		 
		 //For Sorting 
		 List<User> sortedUserList = userList.stream()
		            .sorted(Comparator.comparing(User::getUserName))
		            .collect(Collectors.toList());
	        model.addAttribute("userList", sortedUserList);
		return "add.html";
	}
	
	@PostMapping("/add")
	public String processAdd(@ModelAttribute Ticket ticket) {
		ticketRepo.addTicket(ticket);
		return "redirect:/add";  
	}
	
	@GetMapping("/view")
	public String viewTickets(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    User user = secRepo.findUserByUsername(username);

	    if (secRepo.getRolesById(user.getUserId()).contains("ROLE_VENDER")) {
	      model.addAttribute("mytickets", ticketRepo.getTickets2());
	    } else {
	        model.addAttribute("mytickets", ticketRepo.getTicketsByUserId(user.getUserId()));
	        }
	    
	    return "view.html";
	}
	
	@GetMapping("/edit/{id}")
	public String editTicket(Model model,@PathVariable int id) {
		Ticket ticket = ticketRepo.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "edit.html";
	}
	
	@PostMapping("/edit")
	public String processEdit(Model model,@ModelAttribute Ticket ticket) {
		ticketRepo.editticket(ticket);
		return "redirect:/view"; 
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTicket(Model model,@PathVariable int id) {
		ticketRepo.deleteTicketById(id);
		return "redirect:/view";
	}
}
