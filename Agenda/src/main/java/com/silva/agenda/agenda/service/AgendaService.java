package com.silva.agenda.agenda.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	@Autowired
	IAgendaRepository repository;

	@Transactional
	public AgendaDTO inserir(AgendaDTO dto) {
		validarNomeCompromisso(dto.getNomeCompromisso());
		validarDataCompromisso(dto.getData());
		Agenda agenda = converter.toDtoToEntity(dto);
		repository.save(agenda);
		return converter.toEntityToDto(agenda);
	}

	@Transactional
	public List<AgendaDTO> listar() {
		List<Agenda> lista = repository.findAll();
		if (lista.isEmpty()) {
			throw new NegocioException(Mensagens.MSG_NENHUM_REGISTRO);
		}
		return converter.toListEntityToDto(lista);
	}

	@Transactional
	public AgendaDTO atualizar(AgendaDTO dto) {
		validarId(dto.getId());
		Agenda agenda = converter.toDtoToEntity(dto);
		repository.save(agenda);
		return converter.toEntityToDto(agenda);
	}

	@Transactional
	public Long remover(Long id) {
		validarId(id);
		repository.deleteById(id);
		return id;
	}

	private void validarId(Long id) {
		Optional<Agenda> agenda = repository.findById(id);
		if (!agenda.isPresent()) {
			throw new NegocioException(Mensagens.MSG_NENHUM_REGISTRO);
		}
	}

	private void validarDataCompromisso(Date data) {
		Optional<Date> optData = repository.findByData(data);

		if (!optData.isPresent()) {
			throw new NegocioException(Mensagens.DATA_EXISTENTE);
		}

	}

	private void validarNomeCompromisso(String nomeCompromisso) {
		Optional<String> optNome = repository.findByNomeCompromisso(nomeCompromisso);

		if (!optNome.isPresent()) {
			throw new NegocioException(Mensagens.NOME_EXISTENTE);
		}
	}

}
