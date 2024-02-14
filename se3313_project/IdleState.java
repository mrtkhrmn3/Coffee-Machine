/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313_project;

/**
 *
 * @author Mert
 */
class IdleState implements CoffeeMachineState {
    CoffeeMachineModel cmm;

    public IdleState(CoffeeMachineModel cmm) {
        this.cmm = cmm;
    }
    
    @Override
    public void start() {
        
        cmm.setCurrentState(cmm.getBrewingState());
        cmm.setMessage("Brewing started...");
        

        
    }

    @Override
    public void filled(int cupsFilled) {
        cmm.setMessage("You already filled the machine.");
    }

    @Override
    public void reset() {
        cmm.setMessage("You can only reset at done state.");
        
    }
}