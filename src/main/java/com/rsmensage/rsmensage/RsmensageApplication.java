package com.rsmensage.rsmensage;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsmensage.rsmensage.model.Mensagem;
import com.rsmensage.rsmensage.repository.MensagemRepository;

@SpringBootApplication
public class RsmensageApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsmensageApplication.class, args);
	}

	@Bean
    CommandLineRunner runner(MensagemRepository mensagemRepository) {
        return args -> {
            // Carrega o arquivo JSON com as mensagens
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Mensagem>> typeReference = new TypeReference<>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/mensagens.json");

            // Converte o JSON para uma lista de objetos Mensagem
            List<Mensagem> mensagens = mapper.readValue(inputStream, typeReference);

            // Salva as mensagens no banco de dados
            mensagemRepository.saveAll(mensagens);

            // Log para confirmar que as mensagens foram carregadas
            System.out.println("Mensagens carregadas no banco de dados!");
        };
    }
}
