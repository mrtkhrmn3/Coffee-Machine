/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313_project;

/**
 *
 * @author Mert
 */
class DoneState implements CoffeeMachineState {
    CoffeeMachineModel cmm;

    public DoneState(CoffeeMachineModel cmm) {
        this.cmm = cmm;
        
    }
    @Override
    public void start() {
        cmm.setMessage("You can't start at done state.");
    }

    @Override
    public void filled(int cupsFilled) {
        cmm.setMessage("You can't fill at done state.");
    }

    @Override
    public void reset() {
        cmm.setCurrentState(cmm.getEmptyState());
        cmm.setCupsFilled(0);
        cmm.setMessage("Machine reset");
        
       
    }
   
}
