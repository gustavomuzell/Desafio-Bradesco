package desafio.consultaenderecocep.service;

import desafio.consultaenderecocep.model.ConsultaEnderecoResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnderecoServiceTest {

    @Test
    void consultaEnderecoSudeste() {
        EnderecoService enderecoService = new EnderecoService();
        String cepEsperado = "08770100";
        double freteEsperado = 7.85;
        ConsultaEnderecoResponse response = enderecoService.consultaEndereco(cepEsperado);
        String cepAtual = response.getCep().replaceAll("\\D+", "");
        assertEquals(cepEsperado, cepAtual);
        assertEquals(freteEsperado, response.getFrete());
    }

    @Test
    void consultaEnderecoCentroOeste() {
        EnderecoService enderecoService = new EnderecoService();
        String cepEsperado = "74675700";
        double freteEsperado = 12.50;
        ConsultaEnderecoResponse response = enderecoService.consultaEndereco(cepEsperado);
        String cepAtual = response.getCep().replaceAll("\\D+", "");
        assertEquals(cepEsperado, cepAtual);
        assertEquals(freteEsperado, response.getFrete());
    }

    @Test
    void consultaEnderecoNordeste() {
        EnderecoService enderecoService = new EnderecoService();
        String cepEsperado = "40050003";
        double freteEsperado = 15.98;
        ConsultaEnderecoResponse response = enderecoService.consultaEndereco(cepEsperado);
        String cepAtual = response.getCep().replaceAll("\\D+", "");
        assertEquals(cepEsperado, cepAtual);
        assertEquals(freteEsperado, response.getFrete());
    }

    @Test
    void consultaEnderecoSul() {
        EnderecoService enderecoService = new EnderecoService();
        String cepEsperado = "91030170";
        double freteEsperado = 17.3;
        ConsultaEnderecoResponse response = enderecoService.consultaEndereco(cepEsperado);
        String cepAtual = response.getCep().replaceAll("\\D+", "");
        assertEquals(cepEsperado, cepAtual);
        assertEquals(freteEsperado, response.getFrete());
    }

    @Test
    void consultaEnderecoNorte() {
        EnderecoService enderecoService = new EnderecoService();
        String cepEsperado = "69915024";
        double freteEsperado = 20.83;
        ConsultaEnderecoResponse response = enderecoService.consultaEndereco(cepEsperado);
        String cepAtual = response.getCep().replaceAll("\\D+", "");
        assertEquals(cepEsperado, cepAtual);
        assertEquals(freteEsperado, response.getFrete());
    }
}