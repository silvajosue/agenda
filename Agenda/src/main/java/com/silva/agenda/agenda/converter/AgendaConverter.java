package com.silva.agenda.agenda.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.silva.agenda.agenda.model.Agenda;
import com.silva.agenda.agenda.model.dtos.AgendaDTO;

@Component
public class AgendaConverter {

	public Agenda toDtoToEntity(AgendaDTO dto) {
		Agenda agenda = new Agenda();
		agenda.setId(dto.getId());
		agenda.setNomeCompromisso(dto.getNomeCompromisso());
		agenda.setDescricao(dto.getDescricao());
		agenda.setData(dto.getData());
		return agenda;
	}

	public AgendaDTO toEntityToDto(Agenda agenda) {
		AgendaDTO dto = new AgendaDTO();
		dto.setId(agenda.getId());
		dto.setNomeCompromisso(agenda.getNomeCompromisso());
		dto.setDescricao(agenda.getDescricao());
		dto.setData(agenda.getData());
		return dto;
	}
	
	public List<AgendaDTO> toListEntityToDto(List<Agenda> lista){
		List<AgendaDTO> listDto = new ArrayList<>();
		for (Agenda agenda : lista) {
			AgendaDTO dto = toEntityToDto(agenda);
			listDto.add(dto);
		}
		return listDto;
	}

}
