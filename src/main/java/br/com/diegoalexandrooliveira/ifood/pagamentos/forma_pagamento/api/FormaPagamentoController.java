package br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.api;

import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.FormaPagamento;
import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.FormaPagamentoRepository;
import br.com.diegoalexandrooliveira.ifood.pagamentos.fraude.dominio.AnalisaFormaDePagamentoPorUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/formasPagamento")
@RequiredArgsConstructor
public class FormaPagamentoController {

    private final FormaPagamentoRepository formaPagamentoRepository;
    private final AnalisaFormaDePagamentoPorUsuarioService analisaFormaDePagamentoPorUsuarioService;

    @GetMapping("/restaurante/{idRestaurante}/usuario/{idUsuario}")
    public ResponseEntity<List<FormaPagamento>> formasPorRestauranteEUsuario(@PathVariable("idRestaurante") Long idRestaurente, @PathVariable("idUsuario") Long idUsuario) {
        List<FormaPagamento> todasFormasEncontradas = formaPagamentoRepository.todasFormasPorRestauranteEUsuario(idRestaurente, idUsuario);
        if (todasFormasEncontradas.isEmpty()) {
            return ResponseEntity.ok(List.of());
        }
        return ResponseEntity.ok(analisaFormaDePagamentoPorUsuarioService.filtrar(todasFormasEncontradas, idUsuario));
    }
}
