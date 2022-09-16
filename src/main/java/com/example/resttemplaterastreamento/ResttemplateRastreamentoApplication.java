package com.example.resttemplaterastreamento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.remote.JMXServerErrorException;
import javax.naming.NamingException;

@SpringBootApplication
public class ResttemplateRastreamentoApplication {

	private static Logger logger = LoggerFactory.getLogger(ResttemplateRastreamentoApplication.class);

	public static void main(String[] args)throws NamingException, JMXServerErrorException {
		logger.info("Iniciando integração da API rastreamento de clientes.");
		SpringApplication.run(ResttemplateRastreamentoApplication.class, args);
		logger.info("Integração da API de Rastreamento de Clientes iniciada e pronta para receber requisições");
	}

}
