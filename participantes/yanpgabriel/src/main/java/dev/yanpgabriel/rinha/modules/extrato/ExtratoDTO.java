package dev.yanpgabriel.rinha.modules.extrato;

import dev.yanpgabriel.rinha.modules.transacao.TransacaoDTO;

import java.util.List;

public class ExtratoDTO {
    public SaldoDTO saldo;
    public List<TransacaoDTO> ultimas_transacoes;
}
