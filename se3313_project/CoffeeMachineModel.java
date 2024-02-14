/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se3313_project;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Calendar;

public class CoffeeMachineModel implements Subject{
    private CoffeeMachineState currentState;
    CoffeeMachineState emptyState;
    CoffeeMachineState idleState;
    CoffeeMachineState brewingState;
    CoffeeMachineState doneState;
    
    private int cupsFilled;
    private int totalCups;
    
    private ArrayList<CoffeeMachineObserver> observers;
    
    private BrewingStrategy brewing;
    

    public CoffeeMachineModel() {
        
        emptyState = new EmptyState(this);
        idleState = new IdleState(this);
        brewingState = new BrewingState(this);
        doneState = new DoneState(this);
        
        currentState = emptyState;
        
        
        cupsFilled = 0;
        totalCups = 0;
        
        observers = new ArrayList<CoffeeMachineObserver>();
        
        brewing = new Brewing(this);
       
    }
    
    public void brew(){
        
        brewing.brew();
        
    }
    
     public int getTotalCupsInMonth() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "SELECT SUM(CUPS) FROM information WHERE MONTH(BREW_DATE) = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                
                statement.setInt(1, Calendar.getInstance().get(Calendar.MONTH) + 1);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return 0; 
    }
    
    public void insertBrewedCoffee(int cups) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "INSERT INTO information (CUPS, BREW_DATE) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, cups);
                statement.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    
    

    public CoffeeMachineState getCurrentState() {
        return currentState;
    }
    
    public CoffeeMachineState getEmptyState(){
        return emptyState;
    }
    
    public CoffeeMachineState getIdleState(){
        return idleState;
    }
    
    public CoffeeMachineState getBrewingState(){
        return brewingState;
    }
    
    public CoffeeMachineState getDoneState(){
        return doneState;
    }

    public void setCurrentState(CoffeeMachineState currentState) {
        this.currentState = currentState;
    }
    
    
    public int getCupsFilled() {
        return cupsFilled;
    }

    public void setCupsFilled(int cupsFilled) {
        this.cupsFilled = cupsFilled;
    }

    public int getTotalCups() {
        return totalCups;
    }

    public void setTotalCups(int totalCups) {
        this.totalCups = totalCups;
    }


   
    public void handleUserActionStart() {
        
            getCurrentState().start();
        
       
        
            
        
    }

    public void handleUserActionFilled(int cupsFilled) {
            
            getCurrentState().filled(cupsFilled);
            
            
            
    }

    public void handleUserActionReset() {
      
            getCurrentState().reset();
            
    }
    
    
   
   

    
    
    private String message;
    
    public void addObserver(CoffeeMachineObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CoffeeMachineObserver observer) {
        int i = observers.indexOf(observer);
        if(i >= 0){
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (CoffeeMachineObserver observer : observers) {
            observer.update(message);
        }
    }
    
    public void showMessage(){
        notifyObservers();
    }
    
    public void setMessage(String message){
        this.message = message;
        showMessage();
    }
    
    public String getMessage(){
        return message;
    }
   
    
    
}

