package com.ahbap.geonames.geonames;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Geoname{
    public String summary;
    public int elevation;
    public int geoNameId;
    public String feature;
    public double lng;
    public String countryCode;
    public int rank;
    public String thumbnailImg;
    public String lang;
    public String title;
    public double lat;
    public String wikipediaUrl;
}