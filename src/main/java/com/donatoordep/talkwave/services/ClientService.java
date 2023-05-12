package com.donatoordep.talkwave.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donatoordep.talkwave.controllers.ClientController;
import com.donatoordep.talkwave.dto.ClientDTO;
import com.donatoordep.talkwave.exceptions.ResourceNotFoundException;
import com.donatoordep.talkwave.mapper.ClientMapper;
import com.donatoordep.talkwave.repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private ClientMapper mapper;

	// Find Client by Key
	public ClientDTO findByKey(Long id) {
		return mapper
				.toDto(repository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Error: Resource not found")))
				.add(linkTo(methodOn(ClientController.class).findById(id)).withSelfRel());
	}

	// Update data of account
	public ClientDTO update(ClientDTO dto) {
		ClientDTO client = findByKey(dto.getId());
		newData(client, dto);
		return mapper.toDto(repository.save(mapper.toEntity(client)));
	}

	// Set new data
	public ClientDTO newData(ClientDTO newObj, ClientDTO dto) {
		newObj.setEmail(dto.getEmail());
		newObj.setName(dto.getName());
		newObj.setPassword(dto.getPassword());
		newObj.setUsername(dto.getUsername());
		newObj.setId(dto.getId());
		newObj.setRooms(dto.getRooms());

		return newObj;
	}

	// Delete user with Key
	public void deleteByKey(Long id) {
		repository.deleteById(id);
	}

	// Insert a new Client
	public ClientDTO insert(ClientDTO dto) {
		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}
}
