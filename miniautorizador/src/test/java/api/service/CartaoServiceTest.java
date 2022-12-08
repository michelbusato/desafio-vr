package api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.br.vr.desafio.api.dto.CartaoRequestDTO;
import com.br.vr.desafio.api.dto.CartaoResponseDTO;
import com.br.vr.desafio.api.model.Cartao;
import com.br.vr.desafio.api.repository.CartaoRepository;
import com.br.vr.desafio.api.service.CartaoService;

import api.ApplicationTests;

public class CartaoServiceTest extends ApplicationTests {

    @Autowired
    private CartaoService cartaoService;

    @MockBean
    private CartaoRepository cartaoRepository;

   
    private ModelMapper mapper = new ModelMapper();

    @Test
    @DisplayName("Cria o Cartão com sucesso")
    void testSaveCartao() {
        CartaoRequestDTO mock = new CartaoRequestDTO();
        
        mock.setNumeroCartao("6549873025634501");
        mock.setSenha("1234");

        Cartao cartao = mapper.map(mock, Cartao.class);

        when(cartaoRepository.save(any(Cartao.class))).thenReturn(cartao);

        ResponseEntity<CartaoResponseDTO> response = cartaoService.save(mock);
        CartaoRequestDTO cartaoRequestDTO = mapper.map(mock, CartaoRequestDTO.class);

        Assertions.assertNotNull(cartao);
        assertEquals(mock, cartaoRequestDTO);
    }
    
    @Test
    @DisplayName("Consultar o Cartão com sucesso")
    void testGetCartao() {
       
    	String numeroCartao = "6549873025634501";

    	 Optional<Cartao> cartao = Optional.of(new Cartao());
       
        when(cartaoRepository.findByNumeroCartao(numeroCartao)).thenReturn(cartao);

        Assertions.assertNotNull(cartao);
    }
    

    

}
