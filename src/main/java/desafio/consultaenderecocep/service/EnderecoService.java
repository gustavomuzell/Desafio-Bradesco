package desafio.consultaenderecocep.service;

import desafio.consultaenderecocep.model.ConsultaEnderecoResponse;
import desafio.consultaenderecocep.model.Endereco;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

    private static final String URL_VIACEP = "https://viacep.com.br/ws/%s/json/";

    public ConsultaEnderecoResponse consultaEndereco(String cep) {
        String cepApenasNumeros = cep.replaceAll("\\D+", "");
        if (cepApenasNumeros.length() != 8) {
            return null;
        }
        Endereco endereco = consultaEnderecoPorCep(cepApenasNumeros);
        if (endereco.getUf() == null) {
            return null;
        }
        double frete = calculaFrete(endereco.getUf());
        return new ConsultaEnderecoResponse(endereco, frete);
    }

    private Endereco consultaEnderecoPorCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(URL_VIACEP, cep);
        ResponseEntity<Endereco> response = restTemplate.getForEntity(url, Endereco.class);
        return response.getStatusCodeValue() != 200
                ? null
                : response.getBody();
    }

    private double calculaFrete(String uf) {
        if (uf.equalsIgnoreCase("SP") || uf.equalsIgnoreCase("RJ") || uf.equalsIgnoreCase("MG") || uf.equalsIgnoreCase("ES")) {
            return 7.85;
        } else if (uf.equalsIgnoreCase("GO") || uf.equalsIgnoreCase("MT") || uf.equalsIgnoreCase("MS") || uf.equalsIgnoreCase("DF")) {
            return 12.50;
        } else if (uf.equalsIgnoreCase("BA") || uf.equalsIgnoreCase("SE") || uf.equalsIgnoreCase("AL") || uf.equalsIgnoreCase("PE") || uf.equalsIgnoreCase("PB") || uf.equalsIgnoreCase("RN") || uf.equalsIgnoreCase("CE") || uf.equalsIgnoreCase("PI") || uf.equalsIgnoreCase("MA")) {
            return 15.98;
        } else if (uf.equalsIgnoreCase("PR") || uf.equalsIgnoreCase("SC") || uf.equalsIgnoreCase("RS")) {
            return 17.30;
        } else if (uf.equalsIgnoreCase("AC") || uf.equalsIgnoreCase("AP") || uf.equalsIgnoreCase("AM") || uf.equalsIgnoreCase("PA") || uf.equalsIgnoreCase("RO") || uf.equalsIgnoreCase("RR") || uf.equalsIgnoreCase("TO")) {
            return 20.83;
        } else {
            throw new RuntimeException("Estado não encontrado");
        }
    }
}
