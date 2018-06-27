package com.utn.controllerTest;

import com.utn.WebserviceApplication;
import com.utn.controllers.AirportController;
import com.utn.services.AirportService;
import com.utn.services.RoadService;
import com.utn.wrappers.AirportWrapperWS;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.http.HTTPException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by Matias on 27/06/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebserviceApplication.class)
public class AirportControllerTest {
    @Mock
    AirportService airportService;

    @Mock
    RoadService roadService;

    @InjectMocks
    AirportController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest(){
        List<AirportWrapperWS> list = new LinkedList<>();
        list.add(new AirportWrapperWS("Astor Piazolla","MDQ"));
        when(airportService.findAll()).thenReturn(list);
        ResponseEntity responseEntity= controller.getAll();
        assertEquals(responseEntity.getBody(),list);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getAllEmptyTest(){
        List<AirportWrapperWS> list = new LinkedList<>();
        when(airportService.findAll()).thenReturn(list);
        ResponseEntity responseEntity = controller.getAll();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void getAllServerErrorTest(){
        when(airportService.findAll()).thenThrow(HTTPException.class);
        ResponseEntity responseEntity = controller.getAll();
        assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void
}
