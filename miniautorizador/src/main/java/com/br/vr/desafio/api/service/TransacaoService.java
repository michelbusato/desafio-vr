package com.br.vr.desafio.api.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.vr.desafio.api.dto.TransacaoRequestDTO;
import com.br.vr.desafio.api.model.Cartao;
import com.br.vr.desafio.api.model.Transacao;
import com.br.vr.desafio.api.repository.CartaoRepository;
import com.br.vr.desafio.api.repository.TransacaoRepository;

@Service
@Transactional
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    private ModelMapper mapper = new ModelMapper();


    public ResponseEntity<String> save(TransacaoRequestDTO transacaoRequestDTO) {
        Optional<Cartao> cartao = cartaoRepository.findByNumeroCartao(transacaoRequestDTO.getNumeroCartao());
        while (!cartao.isEmpty()) {
                while (cartao.get().getSenha().equals(transacaoRequestDTO.getSenhaCartao())) {
                    while (cartao.get().getSaldo().compareTo(transacaoRequestDTO.getValor()) >= 0) {
                        Transacao transacao = mapper.map(transacaoRequestDTO, Transacao.class);
                        transacao.setCartao(cartao.get());
                        transacaoRepository.save(transacao);
                        return ResponseEntity.status(HttpStatus.OK).body("OK");
                    }
                    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("SALDO_INSUFICIENTE");
                }
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("SENHA_INVALIDA");
            
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("CARTAO_INEXISTENTE");
    }


}