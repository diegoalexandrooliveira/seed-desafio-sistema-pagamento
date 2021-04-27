package br.com.diegoalexandrooliveira.ifood.pagamentos.usuario.dominio;

import br.com.diegoalexandrooliveira.ifood.pagamentos.forma_pagamento.dominio.FormaPagamento;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "usuario_forma_pagamento",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_forma_pagamento")
    )
    private Set<FormaPagamento> formasPagamento;
}
