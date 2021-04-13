package com.silva.agenda.agenda.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.agenda.agenda.converter.AgendaConverter;
import com.silva.agenda.agenda.exceptions.NegocioException;
import com.silva.agenda.agenda.model.Agenda;
import com.silva.agenda.agenda.model.dtos.AgendaDTO;
import com.silva.agenda.agenda.repository.IAgendaRepository;
import com.silva.agenda.agenda.util.Mensagens;

@Service
public class AgendaService {

	@Autowired
	private AgendaConverter converter;
	
	@Autowired IAgendaRepository repository;
	
	public AgendaDTO inserir(AgendaDTO dto) {
		validarNomeCompromisso(dto.getNomeCompromisso());
		validarDataCompromisso(dto.getData());
		Agenda agenda = converter.toDtoToEntity(dto);
		repository.save(agenda);
		return null;
	}

	private void validarDataCompromisso(Date data) {
		Optional<Date> optData = repository.findByData(data);
		
		if(!optData.isPresent()) {throw new NegocioException(Mensagens.DATA_EXISTENTE);}
		
	}

	private void validarNomeCompromisso(String nomeCompromisso) {
		Optional<String> optNome = repository.findByNomeCompromisso(nomeCompromisso);
		
		if(!optNome.isPresent()) {throw new NegocioException(Mensagens.NOME_EXISTENTE);}
	}

}
