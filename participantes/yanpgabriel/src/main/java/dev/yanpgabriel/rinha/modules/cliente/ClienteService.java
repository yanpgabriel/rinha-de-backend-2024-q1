package dev.yanpgabriel.rinha.modules.cliente;

import dev.yanpgabriel.rinha.exceptions.NaoEncontradoException;
import dev.yanpgabriel.rinha.exceptions.RegraDeNegocioException;
import dev.yanpgabriel.rinha.modules.extrato.ExtratoDTO;
import dev.yanpgabriel.rinha.modules.extrato.SaldoDTO;
import dev.yanpgabriel.rinha.modules.transacao.TipoTransacao;
import dev.yanpgabriel.rinha.modules.transacao.TransacaoDTO;
import dev.yanpgabriel.rinha.modules.transacao.TransacaoEntity;
import dev.yanpgabriel.rinha.modules.transacao.TransacaoEntradaDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ClienteService {

    public ClienteEntity clienteExiste(Integer idCliente) {
        var cliente = ClienteEntity.findByIdOptional(idCliente)
                .orElseThrow(NaoEncontradoException::new);
        return (ClienteEntity) cliente;
    }

    public ExtratoDTO obterExtrato(Integer idCliente) {
        var clienteEntity = clienteExiste(idCliente);
        ExtratoDTO extratoDTO = new ExtratoDTO();
        SaldoDTO saldoDTO = new SaldoDTO();

        saldoDTO.limite = clienteEntity.limite;
        saldoDTO.total = clienteEntity.saldo_atual;
        saldoDTO.data_extrato = LocalDateTime.now();

        extratoDTO.saldo = saldoDTO;

        List<TransacaoDTO> list = TransacaoEntity.find("cliente.id = ?1 order by id desc", clienteEntity.id)
                .page(0, 10)
                .list()
                .stream().map(t -> ((TransacaoEntity)t).toDTO())
                .toList();

        extratoDTO.ultimas_transacoes = list;

        return extratoDTO;
    }

    @Transactional
    public SaldoResumidoDTO efetuarTransacao(Integer idCliente, TransacaoEntradaDTO transacaoEntradaDTO) {
        var clienteEntity = clienteExiste(idCliente);
        var novoSaldo = 0;

        if (transacaoEntradaDTO.tipo == TipoTransacao.c) {
            novoSaldo = clienteEntity.saldo_atual + transacaoEntradaDTO.valor;
        } else {
            novoSaldo = clienteEntity.saldo_atual - transacaoEntradaDTO.valor;
        }

        if (novoSaldo < (clienteEntity.limite*-1)) {
            throw new RegraDeNegocioException("Limite estourou bro!");
        }

        TransacaoEntity transacaoEntity = transacaoEntradaDTO.toEntity();
        transacaoEntity.cliente = clienteEntity;
        transacaoEntity.persist();
        clienteEntity.saldo_atual = novoSaldo;

        return new SaldoResumidoDTO(novoSaldo, clienteEntity.limite);
    }
}
