package com.kids.nasaPractice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NasaPracticeDriverTests {

    @Test
    public void givenDay_returnString(){
        // Arrange
        NasaPracticeDriverImpl nasaPracticeDriver = new NasaPracticeDriverImpl();

        // Act
        String response = nasaPracticeDriver.callNasa("1995-10-21");

        // Assert
        System.out.println(response);
        assertNotNull(response);
    }

}
