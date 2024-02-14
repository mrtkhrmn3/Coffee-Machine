/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se3313_project;

/**
 *
 * @author Mert
 */
public interface CoffeeMachineState {
    void start();
    void filled(int cupsFilled);
    void reset();
}
