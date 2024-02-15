package dev.yanpgabriel.rinha.modules.cliente;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class SaldoResumidoDTO {

    public Integer saldo;
    public Integer limite;

    public SaldoResumidoDTO(Integer saldo, Integer limite) {
        this.saldo = saldo;
        this.limite = limite;
    }
}
