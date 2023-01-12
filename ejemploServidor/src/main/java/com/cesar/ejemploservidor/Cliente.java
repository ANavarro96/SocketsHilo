/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesar.ejemploservidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleja
 */
public class Cliente implements Runnable {
    
    private Socket socket;
    PrintWriter salida;
    BufferedReader entrada;

    public Cliente(Socket socket) {
        try {
            this.socket = socket;
            // Establece los flujos de salida y entrada (desde y hacia el cliente, respectivamente)
            salida = new PrintWriter(socket.getOutputStream(),true);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run() {
        try {
            // Envía algunos ç
            salida.println("Hola " + socket.getInetAddress().getHostAddress());
            salida.println("Dame dos numeros y te devuelvo la suma :)");
            /*
            * Esta sucesión de instrucciones siempre ocurrirá en este
            * orden.
            */
            int n1 = Integer.parseInt(entrada.readLine());
            System.out.println("El primer operando es:  " + n1);
            
            int n2 = Integer.parseInt(entrada.readLine());
            System.out.println("El segundo operando es:  " + n2);
            
            
            salida.println("Te paso la suma:" + (n1 + n2) );
            
            
            salida.println("Hasta otra, amigo del alma . . .");
            // Cierra la conexión con el cliente
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

                   
    }
    
}
