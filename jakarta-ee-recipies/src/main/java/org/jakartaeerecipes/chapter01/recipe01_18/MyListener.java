/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jakartaeerecipes.chapter01.recipe01_18;

import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;

import java.io.IOException;

/**
 * @author Juneau
 */
public class MyListener implements AsyncListener {

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("Performing onComplete");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("Performing onTimeout");
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("Performing onError");
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("Performing onStartAsync");
    }
}
