package dev.yanpgabriel.rinha.modules.cliente;

import dev.yanpgabriel.rinha.modules.transacao.TransacaoEntradaDTO;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService service;

    @POST
    @Path("/{idCliente}/transacoes")
    @RunOnVirtualThread
    public Response transacoes(@PathParam("idCliente") Integer idCliente,
                               @Valid TransacaoEntradaDTO transacaoEntradaDTO) {
        var saldo = service.efetuarTransacao(idCliente, transacaoEntradaDTO);
        return Response.ok(saldo).build();
    }

    @GET
    @Path("/{idCliente}/extrato")
    @RunOnVirtualThread
    public Response extrato(@PathParam("idCliente") Integer idCliente) {
        var extratoDTO = service.obterExtrato(idCliente);
        return Response.ok(extratoDTO).build();
    }

}
