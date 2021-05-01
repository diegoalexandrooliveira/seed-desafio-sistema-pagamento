package br.com.diegoalexandrooliveira.ifood.pagamentos.fraude.dominio;

import br.com.diegoalexandrooliveira.ifood.pagamentos.usuario.dominio.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class PossivelFraudeImplService implements PossivelFraudeService {

    private final List<String> possiveisFraudadores = List.of("diego@gmail.com");

    @Override
    public Optional<TipoFraude> analise(Usuario usuario) {
       return possiveisFraudadores
                .stream()
                .filter(email -> email.equals(usuario.getEmail()))
                .findAny()
                .map(email -> TipoFraude.ROUBO_CARTAO);
    }
}
