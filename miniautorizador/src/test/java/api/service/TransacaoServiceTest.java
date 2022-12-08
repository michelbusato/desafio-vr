package api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.br.vr.desafio.api.dto.TransacaoRequestDTO;
import com.br.vr.desafio.api.model.Cartao;
import com.br.vr.desafio.api.model.Transacao;
import com.br.vr.desafio.api.repository.CartaoRepository;
import com.br.vr.desafio.api.repository.TransacaoRepository;
import com.br.vr.desafio.api.service.CartaoService;
import com.br.vr.desafio.api.service.TransacaoService;

import api.ApplicationTests;

public class TransacaoServiceTest extends ApplicationTests {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private CartaoService cartaoService;

    @MockBean
    private TransacaoRepository transacaoRepository;

    @MockBean
    private CartaoRepository cartaoRepository;

    private ModelMapper mapper = new ModelMapper();

    @Test
    @DisplayName("Cria a Transação com sucesso")
    void testSaveTransacao() {
    	
    	
    	
    	
    	
    	
        Cartao mock = new Cartao();
        mock.setNumeroCartao("6549873025634501");
        mock.setSenha("1234");
        mock.setSaldo(BigDecimal.valueOf(500));
        

        when(cartaoRepository.findByNumeroCartao("6549873025634501")).thenReturn(Optional.of(mock));

        TransacaoRequestDTO mockTransacao= new TransacaoRequestDTO();
        mockTransacao.setNumeroCartao("6549873025634501");
        mockTransacao.setSenhaCartao("1234");
        mockTransacao.setValor(BigDecimal.valueOf(10));
        


        when(transacaoRepository.save(any(Transacao.class))).thenReturn(mapper.map(mockTransacao, Transacao.class));

        ResponseEntity<String> response = transacaoService.save(mockTransacao);

        Assertions.assertNotNull(response.getBody());
        assertEquals("OK", response.getBody());
    }


}
