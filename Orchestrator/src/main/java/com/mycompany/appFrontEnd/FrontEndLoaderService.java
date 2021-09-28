/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appFrontEnd;

import com.mycompany.orchestrator.IComponentLoader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author alvar
 */
public class FrontEndLoaderService implements IComponentLoader {
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
	
	
	@Override
	public boolean connect() {
		// TODO Auto-generated method stub
		System.out.println(this.path);
		
		
		try {
			 ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "d: && cd Binaries && java -jar "+path);			
			 builder.redirectErrorStream(true);
			 Process p = builder.start();
			 BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			 String line;
			 while (true) {
		            line = r.readLine();
		            if (line == null) { break; }
		            System.out.println(line);
		        }
                         if (line.equals("Error: Unable to access jarfile WeLearnGUI-1.jar")) {
                this.isConnected = false;
                return isConnected;
            }
		}catch(Exception e) {
			this.isConnected = false;
			return isConnected;
		}
		
		this.isConnected = true;
		return isConnected;
		
		
		
		
		
	}
	@Override
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
