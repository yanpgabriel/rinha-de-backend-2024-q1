package dev.yanpgabriel.rinha.modules.extrato;

import dev.yanpgabriel.rinha.modules.transacao.TransacaoDTO;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
public class ExtratoDTO {
    public SaldoDTO saldo;
    public List<TransacaoDTO> ultimas_transacoes;
}
