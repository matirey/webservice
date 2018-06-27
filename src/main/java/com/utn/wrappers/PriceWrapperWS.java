package com.utn.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Matias on 27/06/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceWrapperWS {

    @JsonProperty("price")
    private String price;

    @JsonProperty("cabin")
    private String cabin;

    @JsonProperty("flight")
    private String flight;

    @JsonProperty("valid-from")
    private String from;

    @JsonProperty("valid-to")
    private String to;
}
