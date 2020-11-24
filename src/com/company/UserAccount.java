package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserAccount extends UserAccountUI{

    //Classes
    Scanner kbInput = new Scanner(System.in);

    //ArrayLists
    ArrayList<Double> currentBalance = new ArrayList<>();
    ArrayList<Integer> transactionHistoryID = new ArrayList<>();
    ArrayList<String> transactionHistory = new ArrayList<>();

    //Variables for Person
    String name;
    String password;
    int ID;

    //Variables for deposit and withdraw methods
    double totalBalance;
    double depositAmount;
    double newBalance;
    double withdrawBalance;

    public UserAccount(){

    }

    public UserAccount(String n, String p, int identification){
        this.name = n;
        this.password = p;
        this.ID = identification;
    }

    public void getUsers(String n, String p){
        this.name = n;
        this.password = p;
        this.currentBalance.add(0.0);
    }

    private void getID(){
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).name.equalsIgnoreCase(name) && person.get(i).password.equals(password)){
                this.ID = person.get(i).ID;
            }
        }
    }

    public boolean checkNewUserAccount(){
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).name.equalsIgnoreCase(name) || person.get(i).password.equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean checkUserAccount(){
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).name.equalsIgnoreCase(name) && person.get(i).password.equals(password)){
                return true;
            }
        }
        return false;
    }

    public void depositMethod(){
        getID();
        totalBalance = currentBalance.get(ID);
        System.out.println("\n" + name.substring(0,1).toUpperCase() + name.substring(1) + " your current amount is: " + totalBalance);
        System.out.println("Enter an amount greater than zero");
        depositAmount = kbInput.nextDouble();

        while(depositAmount < 0){
            System.out.println("Enter amount: ");
            depositAmount = kbInput.nextDouble();
        }

        newBalance = (totalBalance + depositAmount);

        transactionHistoryID.add(ID);
        transactionHistory.add("you deposited: " + depositAmount);
        currentBalance.set(ID, newBalance);
        System.out.println("\n" + "Your new balance is: " + newBalance);
    }

    public void withdrawMethod(){
        getID();
        totalBalance = currentBalance.get(ID);
        System.out.println("\n" + name.substring(0,1).toUpperCase() + name.substring(1) + " your current amount is: " + totalBalance);
        System.out.println("Please enter an amount greater than zero");
        withdrawBalance = kbInput.nextDouble();

        while(withdrawBalance < 0){
            System.out.println("Enter amount: ");
            withdrawBalance = kbInput.nextDouble();
        }

        newBalance = (totalBalance - withdrawBalance);
        while(newBalance < 0){
            System.out.println("insufficient funds, reenter amount: ");
            withdrawBalance = kbInput.nextDouble();
            newBalance = (totalBalance - withdrawBalance);
        }

        transactionHistoryID.add(ID);
        transactionHistory.add("you withdrew: " + withdrawBalance);
        currentBalance.set(ID, newBalance);

        System.out.println("\n" + "Your new balance is: " + newBalance);
    }

    public void checkBalance(){
        getID();
        System.out.println(name.substring(0,1).toUpperCase() + name.substring(1) + " your current balance is: " + currentBalance.get(ID));
    }

    public void checkUserTransactionHistory(){
        getID();
        for(int i = 0; i < transactionHistory.size(); i++){
            if(transactionHistoryID.get(i).equals(ID)){
                System.out.println(transactionHistory.get(i));
            }
        }
    }
}
