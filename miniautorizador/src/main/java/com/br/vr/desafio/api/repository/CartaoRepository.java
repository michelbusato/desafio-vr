package com.br.vr.desafio.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.vr.desafio.api.model.Cartao;

@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Long> {

    Optional<Cartao> findByNumeroCartao(String numeroCartao);

}
