package br.com.diegoalexandrooliveira.ifood.pagamentos.fraude.dominio;

import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.FormaPagamento;
import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.ModoPagamento;
import br.com.diegoalexandrooliveira.ifood.pagamentos.usuario.dominio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalisaFormaDePagamentoPorUsuarioService {

    private final PossivelFraudeService possivelFraudeService;
    private final UsuarioRepository usuarioRepository;


    public List<FormaPagamento> filtrar(List<FormaPagamento> formas, Long idUsuario) {
        return possivelFraudeService
                .analise(usuarioRepository.getOne(idUsuario))
                .map(tipoFraude -> apenasMeiosOffine(formas))
                .orElse(formas);
    }

    private List<FormaPagamento> apenasMeiosOffine(List<FormaPagamento> formas) {
        return formas
                .stream()
                .filter(forma -> forma.getModoPagamento().equals(ModoPagamento.OFFLINE))
                .collect(Collectors.toList());
    }
}
