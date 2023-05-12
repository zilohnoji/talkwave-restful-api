package com.donatoordep.talkwave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donatoordep.talkwave.dto.ClientDTO;
import com.donatoordep.talkwave.services.ClientService;

@RestController
@RequestMapping("/api/client/v1")
public class ClientController {

	@Autowired
	ClientService service;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClientDTO> findById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(service.findByKey(id));
	}

	@PostMapping(path = "/insert", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto) {
		return ResponseEntity.ok().body(service.insert(dto));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
		service.deleteByKey(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO dto) {
		return ResponseEntity.ok().body(service.update(dto));
	}

}
