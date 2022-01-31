package com.mycompany.socketapp;

import Server.Server;
import Client.Client;
import Model.Vehicle;

public class main {

    public static void main(String[] args) {


        Server ser = new Server(8085);
        Thread t = new Thread(ser);
        t.start(); 


        Vehicle Bike = new Vehicle();
        Bike.Category = "Motorcycle";
        Bike.Color = "RED";
        Bike.Weight = 575;
        Bike.Brand = "DUCATI";

        Client cli = new Client("localhost", 8085, Bike);

    }
    
}
