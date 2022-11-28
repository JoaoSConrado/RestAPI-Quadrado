package br.com.magnasistemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.api.service.ApiService;
import br.com.magnasistemas.api.vo.ApiVO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ApiService apiService;

	@PostMapping
	public ResponseEntity<Object> gravaArquivo(@RequestBody @Valid ApiVO apiVo) {
		apiService.gravaArquivo(apiVo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
