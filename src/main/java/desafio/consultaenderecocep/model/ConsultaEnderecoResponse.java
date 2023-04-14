package desafio.consultaenderecocep.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaEnderecoResponse {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private double frete;

    public ConsultaEnderecoResponse(Endereco endereco, double frete) {
        this.cep = endereco.getCep();
        this.rua = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getLocalidade();
        this.estado = endereco.getUf();
        this.frete = frete;
    }
}