package br.com.magnasistemas.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.magnasistemas.api.vo.ApiVO;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiControllerTest implements Urls {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	@Order(1)
	void CadastrarDoisNumeros() throws Exception {
		URI uri = new URI(URLAPI);
		ApiVO api = new ApiVO();
		api.setNumero1(5.0d);
		api.setNumero2(5.0d);
		HttpEntity<ApiVO> req = new HttpEntity<ApiVO>(api);
		ResponseEntity<Object> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, req, Object.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	@Order(2)
	void ErroCadastrarDoisNumerosPoisNumerosDiferem() throws Exception {
		URI uri = new URI(URLAPI);
		ApiVO api = new ApiVO();
		api.setNumero1(5.0);
		api.setNumero2(7.0);
		HttpEntity<ApiVO> req = new HttpEntity<ApiVO>(api);
		ResponseEntity<Object> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, req, Object.class);
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}
}
