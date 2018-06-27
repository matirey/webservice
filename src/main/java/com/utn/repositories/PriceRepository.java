package com.utn.repositories;

import com.utn.models.Prices;
import com.utn.wrappers.PriceWrapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.utn.WebserviceApplication.API_URL;

/**
 * Created by Matias on 25/06/2018.
 */
@Repository
public class PriceRepository {

    public Prices findPriceByRoadAndCabin(PriceWrapper priceWrapper){
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("Content-Type", "application/json");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PriceWrapper> request = new HttpEntity<>(priceWrapper,header);
        ResponseEntity<Prices> responseEntity = restTemplate.exchange(API_URL+"/prices",
                HttpMethod.POST, request, new ParameterizedTypeReference<Prices>() {},request);
        return responseEntity.getBody();
    }
}
