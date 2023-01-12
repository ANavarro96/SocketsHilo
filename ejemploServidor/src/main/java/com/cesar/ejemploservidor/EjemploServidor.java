/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cesar.ejemploservidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2 DAM CIFP Cesar Manrique
 */
public class EjemploServidor {

   // Se establece el puerto en el que abrimos el canal de comunicación
   static final int PUERTO = 69;
   
   public static void main(String args[]) {
    try {
            // Se inicia el servidor en el equipo local en el puerto indicado
            ServerSocket socketServidor = new ServerSocket(PUERTO);
            // Espera la conexión con un cliente. accept es un método bloqueante
            
            while(true){
                Socket socketCliente = socketServidor.accept();
                
                new Thread(new Cliente(socketCliente)).start();

            }
                   
    } catch (IOException ioe) {
            ioe.printStackTrace();
    }
}
}
