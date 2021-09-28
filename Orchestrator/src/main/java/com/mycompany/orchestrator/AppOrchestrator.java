/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orchestrator;

import com.mycompany.appAPI.APILoaderService;
import com.mycompany.appCore.AppCore;
import com.mycompany.appFrontEnd.FrontEndLoaderService;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class AppOrchestrator extends Thread {

    private List<String> connections;
    private static APILoaderService API_Loader;
    private static FrontEndLoaderService FRONT_Loader;

    public static void main(String args[]) {
        //Core Welcoming
        //JOptionPane.showMessageDialog(null, "Bienvenido a " + AppCore.getName());

        Thread task1 = new Thread() {
            //Enabling connections with the API
            public void run() {
                apiConnection();
            }
        };

        Thread task2 = new Thread() {
            //Enabling connections with the Front
            public void run() {
                frontEndConnection();
            }
        };

        task1.start();
        task2.start();
    }

    //Method that manages the connections with the API
    public static void apiConnection() {

        String api_path = "WeLearnBack-1.jar";

        // Conectando el API / Backend
        try {
            API_Loader = new APILoaderService(api_path);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Back");
            System.err.print("There was an error when trying to connect to the " + "jar file at: " + api_path
                    + ".  \n Exception: " + e.getMessage());

        }

        if (API_Loader.isConnected()) {
            System.out.println("The connection with the API was successfully performed.");
            JOptionPane.showMessageDialog(null, "Back connection succesful");
        } else {
            JOptionPane.showMessageDialog(null, "No Hay Back");
        }
    }

    public static void frontEndConnection() {

        String front_path = "WeLearnGUI-1.jar";

        // Conectando el API / Backend
        try {
            FRONT_Loader = new FrontEndLoaderService(front_path);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No Front");
            System.err.print("There was an error when trying to connect to the " + "project file at: executables/" + front_path
                    + ".  \n Exception: " + e.getMessage());

        }

        if (FRONT_Loader.isConnected()) {
            System.out.println("The connection with the front project was successfully performed.");
        } else {
            JOptionPane.showMessageDialog(null, "No Hay Front");
        }

    }
}
