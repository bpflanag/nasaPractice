package com.kids.nasaPractice;

import org.springframework.stereotype.Service;

@Service
public class NasaPracticeService {

    public NasaPracticeResponse getNearEarthObjectsGivenDay(String day) {

        if (day == null || day.equals("")){
            throw new EmptyDateException();
        }

        NasaPracticeDriverImpl nasaPracticeDriver = new NasaPracticeDriverImpl();
        String numberOfElements = nasaPracticeDriver.callNasa(day);

        return new NasaPracticeResponse("There number of near earth objects for that day is: " + numberOfElements + "!");
    }
}
