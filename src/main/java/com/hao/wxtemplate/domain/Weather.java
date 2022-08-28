package com.hao.wxtemplate.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Weather {

    @SerializedName("weatherinfo")
    private WeatherInfo weatherInfo;
}
