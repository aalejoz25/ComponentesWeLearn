/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.appCore;

/**
 *
 * @author alvar
 */
public class AppCore {

    private static final String name = "We Learn";

    public AppCore() {
        System.out.println(name);
    }

    public static String getName() {
        return name;
    }
}
