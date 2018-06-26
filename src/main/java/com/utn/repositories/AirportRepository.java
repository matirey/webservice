package com.utn.repositories;

import com.utn.models.Airport;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.utn.WebserviceApplication.API_URL;

/**
 * Created by Matias on 24/06/2018.
 */
@Repository
public class AirportRepository {

    public List<Airport> findAll(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Airport>> responseEntity = restTemplate.exchange(API_URL+"/airports",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Airport>>() {});
        return responseEntity.getBody();
    }
}
