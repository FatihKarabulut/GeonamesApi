package com.ahbap.geonames.geonames;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Earthquake{
    public String datetime;
    public double depth;
    public double lng;
    public String src;
    public String eqid;
    public double magnitude;
    public double lat;
}