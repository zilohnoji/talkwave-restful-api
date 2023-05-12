package com.donatoordep.talkwave.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.donatoordep.talkwave.dto.ClientDTO;
import com.donatoordep.talkwave.entities.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

	ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

	Client toEntity(ClientDTO dto);

	ClientDTO toDto(Client client);
}
