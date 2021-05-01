package br.com.diegoalexandrooliveira.ifood.pagamentos.fraude.dominio;

import br.com.diegoalexandrooliveira.ifood.pagamentos.usuario.dominio.Usuario;

import java.util.Optional;

public interface PossivelFraudeService {

    Optional<TipoFraude> analise(Usuario usuario);
}
