package ca.sheridancollege.patdixan.repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.patdixan.beans.Ticket;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TicketRepository {
	
	private NamedParameterJdbcTemplate jdbc;
	
	public void addTicket() {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO easy_tickets VALUES ()";
		jdbc.update(query, parameters);
	}

	public void addTicket(Ticket ticket) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO easy_tickets (userId, name, age, email, address, phone, sport, ticket) VALUES "
				+ "(:ui, :na, :age, :em, :add, :ph, :sp, :tc)";
		parameters.addValue("ui", ticket.getUserId());
		parameters.addValue("na", ticket.getName());
		parameters.addValue("age", ticket.getAge());
		parameters.addValue("em", ticket.getEmail());
		parameters.addValue("add", ticket.getAddress());
		parameters.addValue("ph", ticket.getPhone());
		parameters.addValue("sp", ticket.getSport());
		parameters.addValue("tc", ticket.getTicket());
		jdbc.update(query, parameters);
		
	}
		public ArrayList<Ticket> getTickets() {
			ArrayList<Ticket> tickets = new ArrayList<Ticket>();
			
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			String query = "SELECT * FROM easy_tickets";
			List<Map<String, Object>> rows =
					jdbc.queryForList(query, parameters);
			for(Map<String, Object> row : rows) {
				Ticket d = new Ticket();
				d.setName((String)row.get("name"));
				d.setAge((int)row.get("age"));
				d.setEmail((String)row.get("email"));
				d.setAddress((String)row.get("address"));
				d.setPhone((int)row.get("phone"));
				d.setSport((String)row.get("sport"));
				d.setTicket((String)row.get("ticket"));
				
				tickets.add(d); 
			}
			return tickets;
		}
		
		public ArrayList<Ticket> getTickets2() {
			
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			String query = "SELECT * FROM easy_tickets";
			ArrayList<Ticket> tickets = 
					(ArrayList<Ticket>) jdbc.query(query, parameters,
			new BeanPropertyRowMapper<Ticket>(Ticket.class));
			
			return tickets;
			}

		public Ticket getTicketById(int id) {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			String query = "SELECT * FROM easy_contacts WHERE id=:meow";
			parameters.addValue("meow", id);
			ArrayList<Ticket> tickets = (ArrayList<Ticket>) jdbc.query(query, parameters,
			new BeanPropertyRowMapper<Ticket>(Ticket.class));
			
			
			if (tickets.size()>0)
				return tickets.get(0);
			else
				return null;
		}

		public void editticket(Ticket ticket) {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			String query = "UPDATE easy_tickets SET name=:na, age=:age, email=:em, address=:add, phone=:ph, sport=:sp, ticket=:tc WHERE id=:meow";
			
			parameters.addValue("meow", ticket.getId());
			parameters.addValue("na", ticket.getName());
			parameters.addValue("age", ticket.getAge());
			parameters.addValue("em", ticket.getEmail());
			parameters.addValue("add", ticket.getAddress());
			parameters.addValue("ph", ticket.getPhone());
			parameters.addValue("sp", ticket.getSport());
			parameters.addValue("tc", ticket.getTicket());
			jdbc.update(query, parameters);
			
		}

		public void deleteTicketById(int id) {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			String query = "DELETE FROM easy_tickets WHERE id=:meow";
			parameters.addValue("meow", id);
			
			jdbc.update(query, parameters);
			
		}
		
		public List<Ticket> getTicketsByUserId(long userId) {
	        MapSqlParameterSource parameters = new MapSqlParameterSource();
	        String query = "SELECT * FROM easy_tickets WHERE userId = :userId";
	        parameters.addValue("userId", userId);
	        return jdbc.query(query, parameters, new BeanPropertyRowMapper<>(Ticket.class));
	    }
		}