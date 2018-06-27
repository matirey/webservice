package com.utn.services;

import com.utn.models.Road;
import com.utn.repositories.RoadRepository;
import com.utn.wrappers.CabinsForRoadWrapper;
import com.utn.wrappers.RoadWrapperWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matias on 27/06/2018.
 */
@Service
public class RoadService {

    @Autowired
    RoadRepository repository;


    public List<RoadWrapperWS> getRoadsByAirportOriginIata(String iata){
        List<Road> roads = repository.getRoadsByAirportOriginIata(iata);
        List<RoadWrapperWS> roadWrapperWS = new LinkedList<>();
        for(Road road : roads){
            String from = road.getAirportorigin().getCity().getName()+" "+road.getAirportorigin().getCity().getCountry().getIsoCode()+" ("+
                    road.getAirportorigin().getIataCode()+")";
            String to = road.getAirportdestiny().getCity().getName()+" ("+road.getAirportdestiny().getCity().getCountry().getIsoCode()+" ("+
                    road.getAirportdestiny().getIataCode()+")";
            roadWrapperWS.add(new RoadWrapperWS(from,to));
        }
        return roadWrapperWS;
    }
}
