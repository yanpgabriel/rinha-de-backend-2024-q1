package dev.yanpgabriel.rinha.modules.extrato;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.LocalDateTime;

@RegisterForReflection
public class SaldoDTO {
    public Integer total;
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSSSS'Z'")
    public LocalDateTime data_extrato;
    public Integer limite;
}
