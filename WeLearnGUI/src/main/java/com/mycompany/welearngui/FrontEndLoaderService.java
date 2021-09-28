/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.welearngui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author alvar
 */
public class FrontEndLoaderService {
    private String path;
	private String command;
	
	private boolean isConnected;
	
	public FrontEndLoaderService(String path) {
		// TODO Auto-generated constructor stub
		this.path = path;
		this.isConnected = false;
		
		//Se ejecuta la conexión
		this.connect();
	}
	
	
	
	public boolean connect() {
		// TODO Auto-generated method stub
		try {
			 ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "d: && cd ../WeLearnGUI/WeLearnUI && npm start");			
			 builder.redirectErrorStream(true);
			 Process p = builder.start();
			 BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			 String line;
			 while (true) {
		            line = r.readLine();
		            if (line == null) { break; }
		            System.out.println(line);
		        }
		}catch(Exception e) {
			System.err.println("Unable to run build src");
			this.isConnected = false;
			return isConnected;
		}
		this.isConnected = false;
		return this.isConnected;
	}
	
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
}
