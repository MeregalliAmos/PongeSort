/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meregalli.amos
 */
public class Clientino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Apertua connessione");
        try {
            Socket server = new Socket("127.0.0.1", 5500);

            PrintWriter out
                    = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(server.getInputStream()));
            Scanner tastiera = new Scanner(System.in);
            String s = "";
            
            while (!s.equals("exit")) {
                char [] lista={'a','b','c','d','e','f','g','h','i','j'};
                for (int i = 0; i < lista.length; i++) {
                    lista[i]=lista[(int) (Math.random()*(10))];
                }
                out.println(lista[0]);
                String risposta = in.readLine();
                System.out.println("risposta del server: " + risposta);
                System.out.println("Hai inserito " + risposta.split(": ")[1] + " caratteri"); 
            }

            in.close();
            server.close();
            System.out.println(""
                    + "Chiusura connessione");
        } catch (IOException ex) {
            Logger.getLogger(Clientino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
