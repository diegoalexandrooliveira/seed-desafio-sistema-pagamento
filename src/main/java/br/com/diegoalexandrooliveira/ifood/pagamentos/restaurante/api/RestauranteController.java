package br.com.diegoalexandrooliveira.ifood.pagamentos.restaurante.api;

import br.com.diegoalexandrooliveira.ifood.pagamentos.restaurante.dominio.Restaurante;
import br.com.diegoalexandrooliveira.ifood.pagamentos.restaurante.dominio.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {


    private final RestauranteRepository restauranteRepository;

    @GetMapping
    public ResponseEntity<List<Restaurante>> buscarTodos() {
        return ResponseEntity.ok().body(restauranteRepository.encontraTodos());
    }

}
