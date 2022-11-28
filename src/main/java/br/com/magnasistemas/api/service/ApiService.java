package br.com.magnasistemas.api.service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.NumeroInvalidoException;
import br.com.magnasistemas.api.vo.ApiVO;

@Service
public class ApiService {

	private static Logger logger = LoggerFactory.getLogger(ApiService.class);

	public void gravaArquivo(ApiVO apiVo) {

		Double numero1 = apiVo.getNumero1();
		Double numero2 = apiVo.getNumero2();

		if (!Objects.equals(numero1, numero2)) {
			throw new NumeroInvalidoException("Número Invalido");
		}

		escreveNoArquivo(numero1, numero2);

	}

	public static void escreveNoArquivo(Double numero1, Double numero2) {

		try (FileWriter escreveArquivo = new FileWriter("/home/conrado/Área de Trabalho/Dev/Archives/Prova Arquivo/log" + LocalDateTime.now() + ".txt")) {

			for (int i = 0; i < numero1; i++) {
				escreveArquivo.write(" x");
			}
			for (int x = 0; x < numero2; x++) {
				escreveArquivo.write("\n" + "x");
				for (int e = 0; e < numero2; e++) {
					escreveArquivo.write("  ");
				}
				escreveArquivo.write("x");
			}
			escreveArquivo.write("\n");
			for (int i = 0; i < numero1; i++) {
				escreveArquivo.write(" x");
			}
			escreveArquivo.close();
			logger.info("Sucesso");
		} catch (IOException e) {
			logger.info("Ocorreu um Erro ao escrever o arquivo");
			e.printStackTrace();
		}
	}

}
