package com.kids.nasaPractice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasaPracticeController {

    @Autowired
    private NasaPracticeService nasaPracticeService;

    @RequestMapping(value = "/getNearEarthObjects", method = RequestMethod.GET)
    public NasaPracticeResponse getNearEarthObjects(@RequestParam(value="day", defaultValue="") String day) {
        return nasaPracticeService.getNearEarthObjectsGivenDay(day);
    }

}
