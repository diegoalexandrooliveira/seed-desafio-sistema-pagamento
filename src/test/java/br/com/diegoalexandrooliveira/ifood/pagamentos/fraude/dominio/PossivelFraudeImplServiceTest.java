package br.com.diegoalexandrooliveira.ifood.pagamentos.fraude.dominio;


import br.com.diegoalexandrooliveira.ifood.pagamentos.usuario.dominio.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PossivelFraudeImplServiceTest {

    @DisplayName("Deve retornar usuario diego@gmail.com como fraude do tipo ROUBO_CARTAO")
    @Test
    void teste() {
        Usuario usuario = new Usuario();
        ReflectionTestUtils.setField(usuario, "email", "diego@gmail.com");

        PossivelFraudeImplService possivelFraudeImplService = new PossivelFraudeImplService();

        Optional<TipoFraude> analise = possivelFraudeImplService.analise(usuario);

        assertThat(analise).contains(TipoFraude.ROUBO_CARTAO);
    }

    @DisplayName("Deve retornar usuario joao@gmail.com como não fraude")
    @Test
    void teste2() {
        Usuario usuario = new Usuario();
        ReflectionTestUtils.setField(usuario, "email", "joao@gmail.com");

        PossivelFraudeImplService possivelFraudeImplService = new PossivelFraudeImplService();

        Optional<TipoFraude> analise = possivelFraudeImplService.analise(usuario);

        assertThat(analise).isEmpty();
    }

}