/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Views.ListFriendFrm;
import Views.LoginFrm;
import javax.swing.JFrame;

/**
 *
 * @author AM
 */
public class ChatClientRun {
    public static void main(String[] args) {
        ClientCtrl client = new ClientCtrl(new LoginFrm());
    }
}
