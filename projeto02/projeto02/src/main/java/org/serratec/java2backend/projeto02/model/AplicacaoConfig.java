package org.serratec.java2backend.projeto02.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class AplicacaoConfig {

	private int valor1;
	private String valor2;
	private String[] array1;
}
