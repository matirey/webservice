package com.utn.services;

import com.utn.models.Airport;
import com.utn.repositories.AirportRepository;
import com.utn.wrappers.AirportWrapperWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matias on 26/06/2018.
 */
@Service
public class AirportService {
    @Autowired
    AirportRepository airportRepository;

    public List<AirportWrapperWS> findAll(){
        List<AirportWrapperWS> airportWrapperWSList = new LinkedList<>();
        List<Airport> airportList = airportRepository.findAll();
        for(Airport airport: airportList){
            String name = airport.getCity().getName()+" ("+airport.getCity().getIataCode()+") "+
                    airport.getName()+" - "+airport.getCity().getState()+" - "+airport.getCity().getCountry().getName();
            String iatacode= airport.getIataCode();
            airportWrapperWSList.add(new AirportWrapperWS(name,iatacode));
        }
        return airportWrapperWSList;
    }
}
