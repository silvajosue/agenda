package com.silva.agenda.agenda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4491884563745910011L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_USUARIO")
	private Long id;

	@Column(name = "NO_USUARIO")
	private String nome;

	@Column(name = "NO_SOBRENOME_USUARIO")
	private String sobrenome;

	@Column(name = "NO_EMAIL")
	private String email;

	@Column(name = "PS_PASSWORD")
	private String password;

	@Column(name = "NO_USERNAME")
	private String username;
}
