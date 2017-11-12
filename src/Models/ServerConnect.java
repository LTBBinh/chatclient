/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AM
 */
public class ServerConnect {
    private Socket socket;

    public ServerConnect(String serverName,int port) {
        try {
            socket = new Socket(serverName,port);
        }
        catch (IOException e) {
            System.out.println("Không kết nối được đến server"); 
        }
    }
    
    public Message receiveMessage () {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Message mess = (Message) in.readObject();
            return mess;
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
        }
        return null;
    }
    
    public void sendMessage(Message mess) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(mess);
        } catch (IOException ex) {
        }
    }
    
}
