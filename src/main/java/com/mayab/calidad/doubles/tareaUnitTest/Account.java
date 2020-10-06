package com.mayab.calidad.doubles.tareaUnitTest;

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    
	ArrayList<Integer> historial;
    int balance;
    String holder;
    AlertListener alerts;
    double comision;
    int zona;
    
    
    public Account(String holder, int initialBalance, AlertListener alerts, int zona){
        this.holder = holder;
        this.balance = initialBalance;
        this.alerts = alerts;
        this.zona = zona;
        this.comision = (double) zona/100;
        historial = new ArrayList<Integer>();
    }
    
    public int getBalance() {
        return this.balance;
    }
    
    public String getHolder(){
        return this.holder;
    }

    void debit(int balance) {
        this.balance -= balance;
        if(this.balance < 100){
            this.alerts.sendAlert(this.holder+", your account balance is below 100");
        }

    }

    int credit(int balance) {
        this.balance += balance;
        return this.balance;
    }
    
    void setAlertListener(AlertListener listener){
        this.alerts = listener;
    }
    
}