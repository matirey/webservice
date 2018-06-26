package com.utn.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Matias on 26/06/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportWrapperWS {

    @JsonProperty("name")
    private String name;

    @JsonProperty("iatacode")
    private String iatacode;
}
