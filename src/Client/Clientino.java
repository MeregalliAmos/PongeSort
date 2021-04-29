/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            
//            while (!s.equals("exit")) {
                char [] lista={'a','b','c','d','e','f','g','h','i','j'};
                for (int i = 0; i < lista.length; i++) {
                    lista[i]=lista[(int) (Math.random()*(10))];
                }
            
            FileOutputStream fos=new FileOutputStream("dati.ser");
            ObjectOutputStream os=new ObjectOutputStream(fos);
            os.writeObject(lista);
            os.flush();
            os.close();
            fos.close();
            FileInputStream fis=new FileInputStream("dati.ser");
            ObjectInputStream is=new ObjectInputStream(fis);
            lista=(char []) is.readObject();
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
            }
//                String risposta = in.readLine();
//                System.out.println("risposta del server: " + risposta);
//            }

            in.close();
            server.close();
            System.out.println(""
                    + "Chiusura connessione");
        } catch (IOException ex) {
            Logger.getLogger(Clientino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Clientino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
