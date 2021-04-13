package com.silva.agenda.agenda.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "TB_AGENDA")
public class Agenda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2630163955472658561L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_AGENDA")
	private Long id;
	
	@Column(name = "NO_AGENDA")
	private String nomeCompromisso;
	
	@Column(name = "DS_AGENDA")
	private String descricao;
	
	@Column(name = "DT_AGENDA")
	private Date data;

}
