package br.com.diegoalexandrooliveira.ifood.pagamentos.restaurante.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query("select distinct r from Restaurante r join fetch r.formasPagamento")
    List<Restaurante> encontraTodos();
}
