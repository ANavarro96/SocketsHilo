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
public class ClienteConectado implements Runnable {
    
    private Socket socket;
    PrintWriter entradaSocketCliente;
    BufferedReader salidaSocketCliente;

    public ClienteConectado(Socket socket) {
        try {
            this.socket = socket;
            // Establece los flujos de salida y entrada (desde y hacia el cliente, respectivamente)
            entradaSocketCliente = new PrintWriter(socket.getOutputStream(),true);
            salidaSocketCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ClienteConectado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void run() {
        try {
            // Envía algunos ç
            entradaSocketCliente.println("Hola " + socket.getInetAddress().getHostAddress());
            entradaSocketCliente.println("Dame dos numeros y te devuelvo la suma :)");
            /*
            * Esta sucesión de instrucciones siempre ocurrirá en este
            * orden.
            */
            int n1 = Integer.parseInt(salidaSocketCliente.readLine());
            System.out.println("El primer operando es:  " + n1);
            
            int n2 = Integer.parseInt(salidaSocketCliente.readLine());
            System.out.println("El segundo operando es:  " + n2);
            
            
            entradaSocketCliente.println("Te paso la suma:" + (n1 + n2) );
            
            
            entradaSocketCliente.println("Hasta otra, amigo del alma . . .");
            // Cierra la conexión con el cliente
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteConectado.class.getName()).log(Level.SEVERE, null, ex);
        }

                   
    }
    
}
