package br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private ModoPagamento modoPagamento;

    private String descricao;

    public FormaPagamento(Tipo tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.modoPagamento = tipo.getModoPagamento();
    }
}
