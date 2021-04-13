package com.silva.agenda.agenda.converter;

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

}
