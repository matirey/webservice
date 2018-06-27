package com.utn.services;

import com.utn.models.CabinsForRoad;
import com.utn.models.Road;
import com.utn.repositories.CabinsForRoadRepository;
import com.utn.wrappers.CabinsWrapperWS;
import com.utn.wrappers.RoadWrapper;
import com.utn.wrappers.RoadWrapperWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matias on 27/06/2018.
 */
@Service
public class CabinsForRoadService {

    @Autowired
    CabinsForRoadRepository repository;

    public List<CabinsWrapperWS> findCabinsForRoadByRoad(RoadWrapper request){
       List<CabinsForRoad> list = repository.findCabinsForRoadByRoad(request);
       List<CabinsWrapperWS> cabinsWrapperWS = new LinkedList<>();
       for(CabinsForRoad cabinsForRoad:list){
           String cabin = cabinsForRoad.getCabin().getName();
           String flight = cabinsForRoad.getRoad().getAirportorigin().getCity().getName()+" - "+
                   cabinsForRoad.getRoad().getAirportdestiny().getCity().getName();
           cabinsWrapperWS.add(new CabinsWrapperWS(cabin,flight));
       }
       return cabinsWrapperWS;
    }
}
