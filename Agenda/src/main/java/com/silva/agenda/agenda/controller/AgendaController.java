package com.silva.agenda.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silva.agenda.agenda.model.dtos.AgendaDTO;
import com.silva.agenda.agenda.service.AgendaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaService service;

	@ApiOperation(value = "Inserir um novo agendamento na agenda")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AgendaDTO> inserir(@RequestBody AgendaDTO dto){
		return ResponseEntity.ok(service.inserir(dto));
	}
}
