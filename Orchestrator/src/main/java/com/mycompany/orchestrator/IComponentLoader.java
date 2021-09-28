/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orchestrator;

/**
 *
 * @author alvar
 */
public interface IComponentLoader {
    /**
	 * This Interface defines the methods in order to connect a subproject for pulling up the entire 
	 * project itself.
	 * 
	 */
	 
	public boolean connect();
	
	public void disconnect();
}
