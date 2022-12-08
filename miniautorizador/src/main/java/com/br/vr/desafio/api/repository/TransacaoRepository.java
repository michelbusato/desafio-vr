package com.br.vr.desafio.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.vr.desafio.api.model.Transacao;

import java.util.List;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Long > {

    List<Transacao> findAll();

}
