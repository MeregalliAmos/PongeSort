/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meregalli.amos
 */
public class Serverino2 implements Runnable{
    private Socket clientSocket;

    public Serverino2(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run(){
        char carattere;
        System.out.println("Serverino partitino: "+clientSocket.getInetAddress());
        try {
            OutputStream versoIlClient= clientSocket.getOutputStream();
            BufferedWriter scrittorino=new BufferedWriter(new OutputStreamWriter(versoIlClient));
            scrittorino.write("Ciaoino sono il serverino");
            InputStream dalClient=clientSocket.getInputStream();
            BufferedReader lettore=new BufferedReader(new InputStreamReader(dalClient));
            carattere=(char) lettore.read();
            System.out.println(carattere);
            lettore.close();
            scrittorino.close();
            System.out.println("Chiusurina della connessioncina effetuatina :'(");
        } catch (IOException ex) {
            Logger.getLogger(Serverino2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}
