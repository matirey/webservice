package com.utn.repositories;

import com.utn.models.Road;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.utn.WebserviceApplication.API_URL;

/**
 * Created by Matias on 25/06/2018.
 */
@Repository
public class RoadRepository {

    public List<Road> getRoadsByAirportOriginIata(String iata){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Road>> responseEntity = restTemplate.exchange(API_URL+"/roads/origin/"+iata,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Road>>() {});
        return responseEntity.getBody();
    }
}
