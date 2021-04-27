package br.com.diegoalexandrooliveira.ifood.pagamentos.restaurante.dominio;

import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.FormaPagamento;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "restaurante_forma_pagamento",
            joinColumns = @JoinColumn(name = "id_restaurante"),
            inverseJoinColumns = @JoinColumn(name = "id_forma_pagamento")
    )
    private Set<FormaPagamento> formasPagamento;
}
