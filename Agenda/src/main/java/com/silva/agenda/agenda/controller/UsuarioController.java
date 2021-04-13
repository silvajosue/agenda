package com.silva.agenda.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silva.agenda.agenda.model.dtos.UsuarioDTO;
import com.silva.agenda.agenda.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@ApiOperation(value = "Endpoint para criação de novo usuario!")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioDTO dto){
		return ResponseEntity.ok(service.inserir(dto));
	}

}
