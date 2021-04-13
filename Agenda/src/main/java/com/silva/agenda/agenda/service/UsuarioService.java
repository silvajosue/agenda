package com.silva.agenda.agenda.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.agenda.agenda.converter.UsuarioConverter;
import com.silva.agenda.agenda.exceptions.NegocioException;
import com.silva.agenda.agenda.model.Usuario;
import com.silva.agenda.agenda.model.dtos.UsuarioDTO;
import com.silva.agenda.agenda.repository.IUsuarioRepository;
import com.silva.agenda.agenda.util.Mensagens;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioRepository repository;
	
	@Autowired
	private UsuarioConverter converter;

	@Transactional
	public UsuarioDTO inserir(UsuarioDTO dto) {
		validarUsername(dto.getUsername());
		validarEmail(dto.getEmail());
		validarId(dto.getId());
		Usuario usuario = converter.toDtoToEntity(dto);
		repository.save(usuario);
		return converter.toEntityToDto(usuario);
	}

	private void validarUsername(String username) {
		Optional<Usuario> optUsername = repository.findByUsername(username);

		if (optUsername.isPresent()) {
			throw new NegocioException(Mensagens.MSG_USUARIO_EXISTENTE);
		}
	}

	private void validarEmail(String email) {

		Optional<Usuario> optUsername = repository.findByEmail(email);

		if (optUsername.isPresent()) {
			throw new NegocioException(Mensagens.MSG_EMAIL_INVALIDO);
		}

	}

	private void validarId(Long id) {
		Optional<Usuario> optUsername = repository.findById(id);

		if (optUsername.isPresent()) {
			throw new NegocioException(Mensagens.MSG_USUARIO_EXISTENTE);
		}
	}

}
