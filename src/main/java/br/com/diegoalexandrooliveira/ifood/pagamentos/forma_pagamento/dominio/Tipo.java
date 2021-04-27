package br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Tipo {
    CARTAO(ModoPagamento.ONLINE),
    DINHEIRO,
    MAQUINA,
    CHEQUE;

    Tipo() {
        this.modoPagamento = ModoPagamento.OFFLINE;
    }

    private ModoPagamento modoPagamento;
}
