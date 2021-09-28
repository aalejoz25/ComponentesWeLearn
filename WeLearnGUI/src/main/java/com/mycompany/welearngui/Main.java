/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.welearngui;

/**
 *
 * @author alvar
 */
public class Main {
    private static FrontEndLoaderService FRONT_Loader;
    
    public static void main(String[] args) {
        frontEndConnection();
    }
    
    
    
    public static void frontEndConnection() {
		
		String front_path = "WeLearnUI";

		// Conectando el API / Backend
		try {
			FRONT_Loader = new FrontEndLoaderService(front_path);
		} catch (Exception e) {
			System.err.print("There was an error when trying to connect to the " + "project file at: executables/" + front_path
					+ ".  \n Exception: " + e.getMessage());
		}

		if (FRONT_Loader.isConnected()) {
			System.out.println("The connection with the front project was successfully performed.");
		} else {
			System.out.println("Failed to connect with the source project at: " + front_path);
		}
		
	}
}
