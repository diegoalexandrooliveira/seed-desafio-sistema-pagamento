package br.com.diegoalexandrooliveira.ifood.pagamentos.fraude.dominio;

import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.FormaPagamento;
import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.ModoPagamento;
import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.Tipo;
import br.com.diegoalexandrooliveira.ifood.pagamentos.usuario.dominio.Usuario;
import br.com.diegoalexandrooliveira.ifood.pagamentos.usuario.dominio.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnalisaFormaDePagamentoPorUsuarioServiceTest {


    @Test
    @DisplayName("Usuario não é fraudulento, retorna todas formas")
    void teste() {
        List<FormaPagamento> formaPagamentos = List.of(new FormaPagamento(Tipo.CARTAO, "Visa"), new FormaPagamento(Tipo.DINHEIRO, "Dinheiro"));

        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        PossivelFraudeService possivelFraudeService = mock(PossivelFraudeService.class);

        AnalisaFormaDePagamentoPorUsuarioService analisaFormaDePagamentoPorUsuarioService = new AnalisaFormaDePagamentoPorUsuarioService(possivelFraudeService, usuarioRepository);

        Usuario usuario = new Usuario();
        ReflectionTestUtils.setField(usuario, "id", 1L);
        ReflectionTestUtils.setField(usuario, "email", "nao_eh_fraude@gmail.com");

        when(usuarioRepository.getOne(1L)).thenReturn(usuario);
        when(possivelFraudeService.analise(usuario)).thenReturn(Optional.empty());

        List<FormaPagamento> formasFiltradas = analisaFormaDePagamentoPorUsuarioService.filtrar(formaPagamentos, 1L);

        assertEquals(2, formasFiltradas.size());
        assertEquals(ModoPagamento.ONLINE, formasFiltradas.get(0).getModoPagamento());
        assertEquals(ModoPagamento.OFFLINE, formasFiltradas.get(1).getModoPagamento());
    }


    @Test
    @DisplayName("Usuario é possível fraude, retorna apenas formas OFFILNE")
    void teste2() {
        List<FormaPagamento> formaPagamentos = List.of(new FormaPagamento(Tipo.CARTAO, "Visa"), new FormaPagamento(Tipo.DINHEIRO, "Dinheiro"));

        UsuarioRepository usuarioRepository = mock(UsuarioRepository.class);
        PossivelFraudeService possivelFraudeService = mock(PossivelFraudeService.class);

        AnalisaFormaDePagamentoPorUsuarioService analisaFormaDePagamentoPorUsuarioService = new AnalisaFormaDePagamentoPorUsuarioService(possivelFraudeService, usuarioRepository);

        Usuario usuario = new Usuario();
        ReflectionTestUtils.setField(usuario, "id", 1L);
        ReflectionTestUtils.setField(usuario, "email", "eh_fraude@gmail.com");

        when(usuarioRepository.getOne(1L)).thenReturn(usuario);
        when(possivelFraudeService.analise(usuario)).thenReturn(Optional.of(TipoFraude.ROUBO_CARTAO));

        List<FormaPagamento> formasFiltradas = analisaFormaDePagamentoPorUsuarioService.filtrar(formaPagamentos, 1L);

        assertEquals(1, formasFiltradas.size());
        assertEquals(ModoPagamento.OFFLINE, formasFiltradas.get(0).getModoPagamento());
    }

}