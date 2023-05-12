package com.donatoordep.talkwave.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	@Column(nullable = true)
	private List<Client> friends;

	@Column(nullable = true)
	private List<Long> rooms;

	@Column(nullable = false)
	private LocalDateTime dateRegister;

	public Client() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Client> getFriends() {
		return friends;
	}

	public void setFriends(List<Client> friends) {
		this.friends = friends;
	}

	public Long getId() {
		return id;
	}

	public List<Long> getRooms() {
		return rooms;
	}

	public LocalDateTime getDateRegister() {
		return dateRegister;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", friends=" + friends + ", rooms=" + rooms + ", dateRegister=" + dateRegister + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateRegister, email, friends, id, password, rooms, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(dateRegister, other.dateRegister) && Objects.equals(email, other.email)
				&& Objects.equals(friends, other.friends) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(rooms, other.rooms)
				&& Objects.equals(username, other.username);
	}

}
