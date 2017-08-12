package com.example.workshopbeeper;

import org.springframework.stereotype.Component;

@Component
public class Beeper {
    public void receiveMessage(String message) {
        System.out.println("Received <" + (String)message + ">");
    }
}
