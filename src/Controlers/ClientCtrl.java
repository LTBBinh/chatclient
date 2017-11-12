/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Models.Account;
import Models.Message;
import Models.ServerConnect;
import Models.User;
import Views.ListFriendFrm;
import Views.LoginFrm;
import Views.SignupFrm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AM
 */
public class ClientCtrl{
    private LoginFrm loginView;
    private SignupFrm signupView;
    private ListFriendFrm listFriendView;
    private final String serverHost = "localhost";
    private final int serverPost = 4804;
    private ServerConnect server;
    private Message receivedMess;
    private boolean valid;
    
    public ClientCtrl(LoginFrm view) {
        this.loginView = view;
        this.loginView.setVisible(true);
        this.loginView.addLoginListener(new LoginListener());
        signupView = this.loginView.getSignupFrm();
        server = new ServerConnect(serverHost,serverPost);
        
    }
    public ClientCtrl() {
    }
    
    public ArrayList<User> loadFriend () {
        return new ArrayList<User>();
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            valid = true;
            Verify();
            if(valid) {
                Account account = new Account(loginView.getUserNameTxf().getText(),new String(loginView.getPassWordPsf().getPassword()));
                Message request = new Message(1);
                request.setData(account);
                server.sendMessage(request);
                receivedMess = server.receiveMessage();
                if (receivedMess.getData().get(0).equals(new String("OK"))) {
                    listFriendView = new ListFriendFrm();
                    listFriendView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    listFriendView.setSize(350,650);
                    listFriendView.setLocationRelativeTo(null);
                    listFriendView.setVisible(true);
                    loginView.setVisible(false);
                }
                else loginView.showFailLoginMessage();
            }
        }
    }
    public void Verify() {
        if (loginView.getUserNameTxf().getText().equalsIgnoreCase("")||new String(loginView.getPassWordPsf().getPassword()).equalsIgnoreCase("")) {
            valid = false;
            JOptionPane.showMessageDialog(loginView,"Thông tin đăng nhập còn thiếu");
        }    
    }
    
}
