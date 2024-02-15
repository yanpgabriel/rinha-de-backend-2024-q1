package dev.yanpgabriel.rinha.modules.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;

@Entity(name = "clientes")
@Cacheable
@RegisterForReflection
public class ClienteEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "cliente_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cliente_seq", allocationSize = 10)
    public Integer id;
    @Column(nullable = false)
    public Integer limite;
    @Column(nullable = false)
    public Integer saldo_inicial;
    @Column(nullable = false)
    public Integer saldo_atual;

}