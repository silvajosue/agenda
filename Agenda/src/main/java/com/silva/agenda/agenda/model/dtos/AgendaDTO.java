package com.silva.agenda.agenda.model.dtos;

import java.util.Date;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendaDTO {

	
	private Long id;
	
	@NotNull
	private String nomeCompromisso;
	
	private String descricao;
	
	@NotNull
	private Date data;

}
