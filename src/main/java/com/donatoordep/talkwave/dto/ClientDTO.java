package com.donatoordep.talkwave.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.donatoordep.talkwave.entities.Client;

public class ClientDTO extends RepresentationModel<ClientDTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;
	private List<Client> friends;
	private List<Long> rooms;
	private LocalDateTime dateRegister = LocalDateTime.now();

	public ClientDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Long> getRooms() {
		return rooms;
	}

	public void setRooms(List<Long> rooms) {
		this.rooms = rooms;
	}

	public List<Client> getFriends() {
		return friends;
	}

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateRegister, email, friends, id, name, password, rooms, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDTO other = (ClientDTO) obj;
		return Objects.equals(dateRegister, other.dateRegister) && Objects.equals(email, other.email)
				&& Objects.equals(friends, other.friends) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(rooms, other.rooms) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", friends=" + friends + ", rooms=" + rooms + ", dateRegister=" + dateRegister + "]";
	}

}
