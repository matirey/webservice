package com.utn.services;

import com.utn.models.Prices;
import com.utn.repositories.PriceRepository;
import com.utn.wrappers.PriceWrapper;
import com.utn.wrappers.PriceWrapperWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Matias on 27/06/2018.
 */
@Service
public class PriceService {
    @Autowired
    PriceRepository priceRepository;

    public PriceWrapperWS findPriceByRoadAndCabin(PriceWrapper request){
        Prices price = priceRepository.findPriceByRoadAndCabin(request);
        PriceWrapperWS priceWrapperWS = new PriceWrapperWS();
        if(price!=null){
            priceWrapperWS.setPrice(price.getPrice().toString());
            priceWrapperWS.setCabin(price.getCabinsforroad().getCabin().getName());
            priceWrapperWS.setFlight(price.getCabinsforroad().getRoad().getAirportorigin().getCity().getName()+" - "+
            price.getCabinsforroad().getRoad().getAirportdestiny().getCity().getName());
            priceWrapperWS.setFrom(price.getFromdate().toString());
            priceWrapperWS.setTo(price.getTodate().toString());
        }
        return priceWrapperWS;
    }
}
