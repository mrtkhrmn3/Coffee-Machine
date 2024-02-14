/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313_project;

/**
 *
 * @author Mert
 */
class EmptyState implements CoffeeMachineState {
    CoffeeMachineModel cmm;
    
    public EmptyState(CoffeeMachineModel cmm){
        this.cmm = cmm;
    }
    @Override
    public void start() {
        cmm.setMessage("Cannot start brewing with an empty machine");
       
        
    }

    @Override
    public void filled(int cupsFilled) {
        
        
        cmm.setCupsFilled(cupsFilled);
        cmm.setCurrentState(cmm.getIdleState());
        cmm.setMessage(cupsFilled + " cups filled." + " Ready to start brewing.");
        
    }

    @Override
    public void reset() {
        cmm.setMessage("You can only reset on the done state.");
        
    }
}
