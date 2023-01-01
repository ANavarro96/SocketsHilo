/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cesar.ejemplocliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
public class EjemploCliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 69;
    
     public static void main(String args[]) {

        Socket socketServidor;
        Scanner teclado;
        

        try {
            socketServidor = new Socket(HOST, PUERTO);
            
            System.out.println("Me he conectado a " + HOST + " en el puerto " + PUERTO);
            PrintWriter salida = new PrintWriter(socketServidor.getOutputStream(),true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketServidor.getInputStream()));
            
            
            teclado = new Scanner(new InputStreamReader(System.in));

            System.out.println(entrada.readLine());
            System.out.println(entrada.readLine());

            
            // Envio al servidor el texto introducido por teclado
            salida.println(teclado.nextLine());
            salida.println(teclado.nextLine());
            // Leo por pantalla la respuesta del servidor
            System.out.println(entrada.readLine());
            
            socketServidor.close();

        } catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
