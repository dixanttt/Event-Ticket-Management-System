package ca.sheridancollege.patdixan.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
	
	private Long userId;
	private int id;
	private String name;
	private int age;
	private String email;
	private String address;
	private int phone;
	private String sport;
	private String ticket;
	
	private String[] sports= {"Cricket", "Football", "Basketball", "Soccer", "Badminton"};
	private String[] tickets= {"Adult - $20", "Children - $10"};
}

