package com.br.vr.desafio.api.service;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.vr.desafio.api.dto.CartaoRequestDTO;
import com.br.vr.desafio.api.dto.CartaoResponseDTO;
import com.br.vr.desafio.api.model.Cartao;
import com.br.vr.desafio.api.repository.CartaoRepository;

@Service
@Transactional
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    private ModelMapper mapper = new ModelMapper();

    public ResponseEntity<CartaoResponseDTO> save(CartaoRequestDTO cartaoRequestDTO) {
        Cartao cartao = mapper.map(cartaoRequestDTO, Cartao.class);
        while (isCardExist(cartao.getNumeroCartao())) {
        	CartaoResponseDTO response = mapper.map(cartaoRequestDTO, CartaoResponseDTO.class);        	
        	return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);   
        }
        try {
        	cartao.setSaldo(BigDecimal.valueOf(500));
            cartao = cartaoRepository.save(cartao);
            CartaoResponseDTO response =  mapper.map(cartao, CartaoResponseDTO.class);
            return ResponseEntity.status(HttpStatus.OK).body(response); 
        } catch (Exception e) {
        	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


	public Optional<Object> getSaldo(String numeroCartao) {
		 Cartao cartao = cartaoRepository.findByNumeroCartao(numeroCartao).orElse(null);
	        while (cartao == null) {
	        	 return Optional.empty();
	        }
	        return Optional.of(cartao.getSaldo());
	}
	
	 public boolean isCardExist(String numerocartao) {
	        return cartaoRepository.findByNumeroCartao(numerocartao).isPresent();
	 }

}