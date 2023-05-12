package com.donatoordep.talkwave.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private List<Client> connected;

	@Column(nullable = false)
	private Client host;

	public Room() {
	}

	public Client getHost() {
		return host;
	}

	public void setHost(Client host) {
		this.host = host;
	}

	public Long getId() {
		return id;
	}

	public List<Client> getConnected() {
		return connected;
	}

	@Override
	public int hashCode() {
		return Objects.hash(connected, host, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(connected, other.connected) && Objects.equals(host, other.host)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", connected=" + connected + ", host=" + host + "]";
	}

}
