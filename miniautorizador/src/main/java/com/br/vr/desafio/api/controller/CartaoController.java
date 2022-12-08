package com.br.vr.desafio.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.vr.desafio.api.dto.CartaoRequestDTO;
import com.br.vr.desafio.api.dto.CartaoResponseDTO;
import com.br.vr.desafio.api.service.CartaoService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RequestMapping( "/cartoes" )
@Tag(name = "Cartões", description = "Operações com Cartões")
@Validated
@RestController
public class CartaoController {

    @Autowired
    private CartaoService service;

    @GetMapping( value = "/{numeroCartao}" )
    public ResponseEntity<Object> getSaldo(@PathVariable String numeroCartao) {
        return service.getSaldo(numeroCartao)
        		.map(result -> new ResponseEntity< >(result, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CartaoResponseDTO> create(@Valid @RequestBody CartaoRequestDTO cartaoRequestDTO) {
        return service.save(cartaoRequestDTO);
    }
}