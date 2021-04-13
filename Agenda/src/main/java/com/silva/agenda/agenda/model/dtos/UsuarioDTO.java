package com.silva.agenda.agenda.model.dtos;

import java.io.Serializable;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2842613086486241914L;

	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String sobrenome;

	@NotNull
	private String email;

	@NotNull
	private String password;

	@NotNull
	private String username;

}
