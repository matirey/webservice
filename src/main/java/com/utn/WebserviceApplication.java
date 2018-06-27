package com.utn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootApplication
public class WebserviceApplication {

    public static final String API_URL= "http://localhost:8090/api";
	public static void main(String[] args) {SpringApplication.run(WebserviceApplication.class, args);}
}
