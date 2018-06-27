package com.utn.controllers;

import com.utn.services.CabinsForRoadService;
import com.utn.services.PriceService;
import com.utn.wrappers.CabinsWrapperWS;
import com.utn.wrappers.PriceWrapper;
import com.utn.wrappers.PriceWrapperWS;
import com.utn.wrappers.RoadWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Matias on 27/06/2018.
 */
@RestController
@RequestMapping("/client/flights")
public class FlightController {

    @Autowired
    CabinsForRoadService cabinsForRoadService;

    @Autowired
    PriceService priceService;

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<List<CabinsWrapperWS>> findCabinsForRoad(@RequestBody RoadWrapper request){
        try{
            List<CabinsWrapperWS> cabinsWrapperWS = cabinsForRoadService.findCabinsForRoadByRoad(request);
            if(cabinsWrapperWS!=null) {
                return new ResponseEntity<>(cabinsWrapperWS, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/prices", consumes = "application/json" , produces = "application/json")
    public @ResponseBody ResponseEntity<PriceWrapperWS> findPriceByRoadAndCabin(@RequestBody PriceWrapper request){
        try {
            PriceWrapperWS priceWrapperWS = priceService.findPriceByRoadAndCabin(request);
            if(priceWrapperWS!=null){
                return new ResponseEntity<PriceWrapperWS>(priceWrapperWS,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<PriceWrapperWS>(HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e){
            return new ResponseEntity<PriceWrapperWS>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
