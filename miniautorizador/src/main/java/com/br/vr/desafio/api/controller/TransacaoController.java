package com.br.vr.desafio.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.vr.desafio.api.dto.TransacaoRequestDTO;
import com.br.vr.desafio.api.service.TransacaoService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RequestMapping( "/transacoes" )
@Tag( name = "Transações", description = "Operações com Transações" )
@Validated
@RestController
public class TransacaoController {

    @Autowired
    private TransacaoService service;

   
    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody TransacaoRequestDTO transacaoRequestDTO) {
    	return service.save(transacaoRequestDTO);
    }

}