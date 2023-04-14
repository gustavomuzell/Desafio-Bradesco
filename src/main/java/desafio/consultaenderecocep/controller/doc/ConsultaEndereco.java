package desafio.consultaenderecocep.controller.doc;

import desafio.consultaenderecocep.model.ConsultaEnderecoRequest;
import desafio.consultaenderecocep.model.ConsultaEnderecoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Consulta")
public interface ConsultaEndereco {

    @Operation(summary = "Consulta um Endereco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quando a requisição foi OK (When the request was OK)"),
            @ApiResponse(responseCode = "400", description = "Quando o cliente envia um REQUISIÇÃO INCORRETA (When the client sends a BAD REQUEST)"),
            @ApiResponse(responseCode = "404", description = "Quando a cliente NÃO FOI ENCONTRADO (When the customer was NOT FOUND)"),
            @ApiResponse(responseCode = "500", description = "Quando ocorre um ERRO INTERNO NO SERVIDOR (When a INTERNAL SERVER ERROR occurs)")
    })
    ResponseEntity<ConsultaEnderecoResponse> consultaEndereco(ConsultaEnderecoRequest consultaEnderecoRequest);
}
