/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.User;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author AM
 */
public class ListFriendFrm extends javax.swing.JFrame implements ActionListener{
    
    private JLabel searchImg;
    private JPanel topPanel;
    private JPanel contactPanel;
    private JTextField inputKey;
    private JButton addBtn;
    private JButton creatGroup;
    private JScrollPane scroll;
    private BufferedImage image;
    private String clickedUser;
    
    public ListFriendFrm() {
        InitComponent();
        ComponentSetting();
        AddComponent();
        addListener();
        showFriend(new ArrayList<User>());
    }
    
    private void showFriend (ArrayList<User> listUser){
        for (int i = 0; i < 100; i++) {
            JButton userButton = new JButton("username"+i,new ImageIcon(image));
           // JButton userButton = new JButton(listUser.get(i).getAccount().getUserName(),new ImageIcon(image));
            userButton.setMaximumSize(new Dimension(300,150));
            userButton.addActionListener(this);
            userButton.setName("I'm Button");
            contactPanel.add(userButton);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       clickedUser = ae.getClass().getName();
    }

    private void InitComponent() {
        topPanel = new JPanel();
        contactPanel = new JPanel();
        addBtn = new JButton();
        creatGroup = new JButton("Tạo nhóm");
        inputKey = new JTextField();
        try {
            image = ImageIO.read(new File("resource/search_icon.png"));
            searchImg = new JLabel(new ImageIcon(image));
            image = ImageIO.read(new File("resource/add_icon.png"));
            addBtn.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("resource/account_icon.png"));

        } catch (IOException ex) {
            Logger.getLogger(ListFriendFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        scroll = new JScrollPane(contactPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void AddComponent() {
        add(topPanel,BorderLayout.PAGE_START);
        topPanel.add(searchImg);  
        topPanel.add(inputKey);
        topPanel.add(addBtn);
        topPanel.add(creatGroup);
        add(scroll,BorderLayout.CENTER);
    }

    private void ComponentSetting() {
        setLayout(new BorderLayout());
        contactPanel.setLayout(new BoxLayout(contactPanel, BoxLayout.Y_AXIS));
        addBtn.setPreferredSize(new Dimension(20,20));
        inputKey.setPreferredSize(new Dimension(100, 30));
        scroll.getVerticalScrollBar().setUnitIncrement(25);
    }

    private void addListener() {
        addBtn.addActionListener(this);
    }
}
