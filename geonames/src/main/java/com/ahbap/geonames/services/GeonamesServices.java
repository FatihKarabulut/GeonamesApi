package com.ahbap.geonames.services;

import com.ahbap.geonames.geonames.EarthQuakeInfo;

import com.ahbap.geonames.geonames.GeonamesInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GeonamesServices {

    private static final String m_Geo = "http://api.geonames.org/earthquakesJSON?north=%.2f&south=%.2f&east=%f&west=%.2f&username=fatihkarabulut";
    private static final String m_GeoWiki = "http://api.geonames.org/wikipediaSearchJSON?&q=%s&maxRows=%d&username=fatihkarabulut";



    private final RestTemplate restTemplate;

    public GeonamesServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public EarthQuakeInfo findBy(double north, double south, double east, double west)
    {

        var url = String.format(m_Geo,north,south,east,west).replace(',','.');
        System.out.println("------------------------------------");
        log.info(url);
        System.out.println("------------------------------------");

        EarthQuakeInfo earth = restTemplate.getForObject(url,EarthQuakeInfo.class);
        log.info(earth.toString());
        return earth;
    }

    public GeonamesInfo findbyGeo(String str, int maxrow)
    {

        var url = String.format(m_GeoWiki,str,maxrow).replace(',','.');
        log.info("url = {}",url);
        var res = restTemplate.getForObject(url,GeonamesInfo.class);
        log.info(res.toString());
        return res;
    }


}
