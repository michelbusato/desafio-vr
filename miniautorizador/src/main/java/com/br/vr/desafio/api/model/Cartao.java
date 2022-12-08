package com.br.vr.desafio.api.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cartao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column(name = "numeroCartao", nullable = false)
    @NotBlank( message = "Número do cartão é obrigatório" )
    private String numeroCartao;

    @Column(name = "senha")
    private String senha;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @CreationTimestamp
    @Temporal( TemporalType.TIMESTAMP )
    private Date data_criacao;

    @UpdateTimestamp
    @Temporal( TemporalType.TIMESTAMP )
    private Date data_alteracao;

}