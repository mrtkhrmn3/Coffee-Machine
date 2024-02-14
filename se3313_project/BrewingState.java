/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313_project;

/**
 *
 * @author Mert
 */
class BrewingState implements CoffeeMachineState {
    CoffeeMachineModel cmm;
    
    

    public BrewingState(CoffeeMachineModel cmm) {
        this.cmm = cmm;
        
    }
    @Override
    public void start() {
        cmm.setMessage("Coffee is already brewing.");
    }

    @Override
    public void filled(int cupsFilled) {
         cmm.setMessage("You can't fill it while the coffee is brewing.");
    }

    @Override
    public void reset() {
         cmm.setMessage("You can only reset at done state.");
    }


    
  
   }

