package br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {


    @Query(
            "select f from FormaPagamento f, Restaurante r join r.formasPagamento rf join FormaPagamento fr on rf = fr, Usuario u join u.formasPagamento uf join FormaPagamento fu on uf = fu " +
                    " where r.id = :idRestaurante and u.id = :idUsuario and fr = f and fu = f " +
                    " order by f.tipo "
    )
    List<FormaPagamento> todasFormasPorRestauranteEUsuario(Long idRestaurante, Long idUsuario);

}
