package com.utn.controllers;

import com.utn.models.Airport;
import com.utn.services.AirportService;
import com.utn.wrappers.AirportWrapperWS;
import javafx.scene.text.Text;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * Created by Matias on 25/06/2018.
 */
@RestController
@RequestMapping("/client/airports")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<AirportWrapperWS>> getAll(){
        try{
            List<AirportWrapperWS> airportList = airportService.findAll();
            return new ResponseEntity<>(airportList,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
