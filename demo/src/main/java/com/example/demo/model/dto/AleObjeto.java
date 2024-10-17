package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AleObjeto {
    @JsonProperty("column1")
    public Integer column1;

    @JsonProperty("column2")
    public Integer column2;

    @JsonProperty("column3")
    public String column3;
}
