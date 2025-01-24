package ca.sheridancollege.patdixan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.patdixan.repositories.SecurityRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class SecurityController {
	
	private SecurityRepository secRepo;
		@GetMapping("/login")
		public String login() {
			return "login.html";
			}
		@GetMapping("/accessDenied")
		public String AccesDenied() {
			return "access-denied.html";
			
	}
		@GetMapping("/register")
		public String register() {
			return "registration.html";
			}
	@PostMapping("/register")
		public String doRegistration(@RequestParam String username,
				@RequestParam String password,
				@RequestParam(required=false, defaultValue="false") boolean venderRole,
				@RequestParam(required=false, defaultValue="false") boolean guestRole){
		secRepo.register(username,password);
		if(venderRole) secRepo.assignRoles(secRepo.findUserByUsername(username).getUserId(), 1);
		if(guestRole) secRepo.assignRoles(secRepo.findUserByUsername(username).getUserId(), 2);
		
		return "redirect:/login";
		}
}
