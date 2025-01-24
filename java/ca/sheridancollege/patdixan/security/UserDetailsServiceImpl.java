package ca.sheridancollege.patdixan.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.patdixan.repositories.SecurityRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl  implements UserDetailsService {
	
	private SecurityRepository secRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		ca.sheridancollege.patdixan.beans.User user = secRepo.findUserByUsername(username);
		if(user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Could not find user");
		}
			
		List<String> roles = secRepo.getRolesById(user.getUserId());
		List<GrantedAuthority> grantList = new ArrayList <GrantedAuthority> ();
		for (String r : roles) {
			grantList.add(new SimpleGrantedAuthority(r));
		}
		User springUser = new User(user.getUserName(),
				user.getEncryptedPassword(), grantList);
		return (UserDetails)springUser;
	}
}
