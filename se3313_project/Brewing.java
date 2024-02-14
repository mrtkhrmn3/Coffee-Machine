/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313_project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Brewing implements BrewingStrategy{
    CoffeeMachineModel cmm;
    
    
    

    public Brewing(CoffeeMachineModel cmm) {
        this.cmm = cmm;
    }
    
   
     public void brew() {                      
            Timer timer = new Timer(15000, new ActionListener(){
                
                @Override
                public void actionPerformed(ActionEvent e) {                                                                                                  
                }                
            });               
            timer.setRepeats(false);
            timer.start();
    }
           
}

