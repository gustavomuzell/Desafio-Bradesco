package desafio.consultaenderecocep.controller;

import desafio.consultaenderecocep.controller.doc.ConsultaEndereco;
import desafio.consultaenderecocep.model.ConsultaEnderecoRequest;
import desafio.consultaenderecocep.model.ConsultaEnderecoResponse;
import desafio.consultaenderecocep.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EnderecoController implements ConsultaEndereco {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/consulta-endereco")
    public ResponseEntity<ConsultaEnderecoResponse> consultaEndereco(@RequestBody ConsultaEnderecoRequest request) {
        ConsultaEnderecoResponse response = enderecoService.consultaEndereco(request.getCep());
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(response);
    }
}
