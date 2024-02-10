package dev.yanpgabriel.rinha.modules.transacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.yanpgabriel.rinha.modules.cliente.ClienteEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "transacoes")
public class TransacaoEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(nullable = false)
    public Integer valor;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public TipoTransacao tipo;
    @Column(nullable = false)
    public String descricao;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
    public LocalDateTime realizada_em;

    @ManyToOne()
    @JoinColumn(name = "id_cliente", nullable = false)
    public ClienteEntity cliente;

    @PrePersist
    public void prePersist() {
        this.realizada_em = LocalDateTime.now();
    }

    public TransacaoDTO toDTO() {
        TransacaoDTO dto = new TransacaoDTO();
        dto.descricao = this.descricao;
        dto.tipo = this.tipo;
        dto.valor = this.valor;
        dto.realizada_em = this.realizada_em;
        return dto;
    }

}