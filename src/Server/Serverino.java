/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meregalli.amos
 */
public class Serverino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(5500);
            System.out.println("Server attivo e in ascolto");
            while(true){
                Socket client=server.accept();
                Thread serverino=new Thread(new Serverino2(client));
                serverino.start();
        }
        } catch (IOException ex) {
            Logger.getLogger(Serverino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
