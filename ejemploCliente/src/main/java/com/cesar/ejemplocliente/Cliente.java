/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cesar.ejemplocliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class Cliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 69;
    
     public static void main(String args[]) {

        Socket socketServidor;
        Scanner teclado;
        

        try {
            socketServidor = new Socket(HOST, PUERTO);
            
            System.out.println("Me he conectado a " + HOST + " en el puerto " + PUERTO);
            PrintWriter entradaDatosCliente = new PrintWriter(socketServidor.getOutputStream(),true);
            BufferedReader salidaDatosCliente = new BufferedReader(new InputStreamReader(socketServidor.getInputStream()));
            
            
            teclado = new Scanner(new InputStreamReader(System.in));

            System.out.println(salidaDatosCliente.readLine());
            System.out.println(salidaDatosCliente.readLine());

            
            // Envio al servidor el texto introducido por teclado
            entradaDatosCliente.println(teclado.nextLine());
            entradaDatosCliente.println(teclado.nextLine());
            // Leo por pantalla la respuesta del servidor
            System.out.println(salidaDatosCliente.readLine());
            
            socketServidor.close();

        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
