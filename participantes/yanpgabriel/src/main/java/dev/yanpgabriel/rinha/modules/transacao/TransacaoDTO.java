package dev.yanpgabriel.rinha.modules.transacao;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.LocalDateTime;

@RegisterForReflection
public class TransacaoDTO {
    public Integer valor;
    public TipoTransacao tipo;
    public String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
    public LocalDateTime realizada_em;
}
