package com.silva.agenda.agenda.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.silva.agenda.agenda.model.Usuario;
import com.silva.agenda.agenda.model.dtos.UsuarioDTO;

@Component
public class UsuarioConverter {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Usuario toDtoToEntity(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setId(dto.getId());
		usuario.setNome(dto.getNome());
		usuario.setSobrenome(dto.getSobrenome());
		usuario.setEmail(dto.getEmail());
		usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
		usuario.setUsername(dto.getUsername());
		return usuario;
	}

	public UsuarioDTO toEntityToDto(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		dto.setSobrenome(usuario.getSobrenome());
		dto.setEmail(usuario.getEmail());
		dto.setUsername(usuario.getUsername());
		dto.setPassword("Erroouu hehe");
		return dto;
	}

}
