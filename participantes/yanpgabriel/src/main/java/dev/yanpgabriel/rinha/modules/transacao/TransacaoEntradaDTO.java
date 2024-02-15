package dev.yanpgabriel.rinha.modules.transacao;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@RegisterForReflection
public class TransacaoEntradaDTO {

    @Positive
    @NotNull
    public Integer valor;
    @NotNull
    public TipoTransacao tipo;
    @NotBlank
    @Size(min = 1, max = 10)
    public String descricao;

    public TransacaoEntity toEntity() {
        TransacaoEntity transacao = new TransacaoEntity();
        transacao.valor = this.valor;
        transacao.tipo = this.tipo;
        transacao.descricao = this.descricao;
        return transacao;
    }
}
