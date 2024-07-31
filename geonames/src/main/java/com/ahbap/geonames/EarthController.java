package com.ahbap.geonames;

import com.ahbap.geonames.services.GeonamesServices;
import com.ahbap.geonames.geonames.EarthQuakeInfo;
import com.ahbap.geonames.geonames.GeonamesInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/geo")
@Slf4j
public class EarthController {
    private final GeonamesServices services;


    public EarthController(GeonamesServices services) {
        this.services = services;

    }

    @GetMapping("/earth/json")
    public EarthQuakeInfo get(@RequestParam double north, @RequestParam double south, @RequestParam double east, @RequestParam double west) {
        log.info("Received request with params - North: {}, South: {}, East: {}, West: {}", north, south, east, west);
        EarthQuakeInfo response = services.findBy(north, south, east, west);
        log.info("Response: {}", response);
        return response;
    }
    @GetMapping("/json")
    public GeonamesInfo get(@RequestParam String str, @RequestParam int maxrow)
    {
        log.info("request Geonames Wiki str = {} maxrow = {}",str,maxrow);

        return services.findbyGeo(str,maxrow);
    }


}
// http://api.geonames.org/earthquakesJSON?north=26.04&south=35.82&east=44.79&west=42.14&username=fatihkarabulut
// http://localhost:6767/api/geo/earth/json?north=26.04&south=35.82&east=44.79&west=42.14
