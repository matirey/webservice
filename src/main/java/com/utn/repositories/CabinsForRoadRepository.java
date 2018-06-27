package com.utn.repositories;

import com.utn.models.CabinsForRoad;
import com.utn.wrappers.RoadWrapper;
import org.omg.CORBA.Context;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.List;

import static com.utn.WebserviceApplication.API_URL;

/**
 * Created by Matias on 27/06/2018.
 */
@Repository
public class CabinsForRoadRepository {

    public List<CabinsForRoad> findCabinsForRoadByRoad(RoadWrapper roadWrapper){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("Content-Type", "application/json");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<RoadWrapper> request = new HttpEntity<>(roadWrapper,header);
        ResponseEntity<List<CabinsForRoad>> responseEntity = restTemplate.exchange(API_URL+"/cabinsforroad",
                HttpMethod.POST, request, new ParameterizedTypeReference<List<CabinsForRoad>>() {});
        return responseEntity.getBody();
    }
}
