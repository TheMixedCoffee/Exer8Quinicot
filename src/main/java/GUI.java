package main.java;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author Monika
 */
public class GUI extends Frame implements ActionListener{
    private Connection con;
    ArrayList<User> userList = new  ArrayList<User>();
    ArrayList<User>  foundList = new ArrayList<User>();
    JList display;
    public GUI(String name){
        menuGUI(name);
    }
    public GUI(){

    }

    public void menuGUI(String name){
        JFrame frame = new JFrame(name);
        JButton addUserBtn = new JButton("Add User");
        addUserBtn.setBounds(25,235,100, 30);
        JButton searchUserBtn = new JButton("Search User");
        searchUserBtn.setBounds(150,235,100, 30);
        frame.add(addUserBtn);
        frame.add(searchUserBtn);
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);
        addUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createGUI("Add User");
            }
        });
        searchUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchGUI("Search User");
            }
        });
    }

    public void searchGUI(String name)
    {
        JFrame frame = new JFrame(name);
        JLabel l1 = new JLabel("Last Name");
        l1.setBounds(25,25, 100,30);
        frame.add(l1);
        JTextField lName = new JTextField();
        lName.setBounds(125,25, 150, 30);
        frame.add(lName);
        JLabel l2 = new JLabel("Contact Number");
        JTextField contactNum = new JTextField();
        contactNum.setBounds(125,55, 150, 30);
        frame.add(contactNum);
        l2.setBounds(25,55, 100,30);
        frame.add(l2);
        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(25,235,100, 30);
        frame.add(searchBtn);
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(User user: userList){
                    if(user.getLName() == lName.getText() || user.getContactNum() == contactNum.getText()){
                        foundList.add(user);
                    }
                }
                display = new JList(foundList.toArray());
                display.setVisibleRowCount(1);
                display.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                frame.add(display);
            }
        });
    }

    public void createGUI(String name){

        JFrame frame=new JFrame(name);
        JLabel l1 = new JLabel("First Name");
        l1.setBounds(25,25, 100,30);
        frame.add(l1);
        JTextField fName = new JTextField();
        fName.setBounds(125,25, 150, 30);
        frame.add(fName);
        JLabel l2 = new JLabel("Last Name");
        l2.setBounds(25,55, 100,30);
        frame.add(l2);
        JTextField lName = new JTextField();
        lName.setBounds(125,55, 150, 30);
        frame.add(lName);
        JLabel l3 = new JLabel("Birth Date");
        l3.setBounds(25,85, 100,30);
        frame.add(l3);
        JTextField bDate = new JTextField();
        bDate.setBounds(125,85, 150, 30);
        frame.add(bDate);
        JLabel l4 = new JLabel("Email");
        l4.setBounds(25,115, 100,30);
        frame.add(l4);
        JTextField email = new JTextField();
        email.setBounds(125,115, 150, 30);
        frame.add(email);
        JLabel l5 = new JLabel("Contact Number");
        l5.setBounds(25,145, 100,30);
        frame.add(l5);
        JTextField contactNum = new JTextField();
        contactNum.setBounds(125,145, 150, 30);
        frame.add(contactNum);
        JLabel l6 = new JLabel("Address");
        l6.setBounds(25,175, 100,30);
        frame.add(l6);
        JTextField address = new JTextField();
        address.setBounds(125,175, 150, 30);
        frame.add(address);
        JButton resetBtn=new JButton("Reset");
        resetBtn.setBounds(25,235,100, 30);
        frame.add(resetBtn);
        JButton saveBtn=new JButton("Save");
        saveBtn.setBounds(150,235,100, 30);
        frame.add(saveBtn);
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setVisible(true);

        saveBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;
                User newUser = new User();
                newUser.setFName(fName.getText());
                newUser.setLName(lName.getText());
                newUser.setbDate(bDate.getText());
                newUser.setEmail(email.getText());
                newUser.setContactNum(contactNum.getText());
                newUser.setAddress(address.getText());
                for(User user: userList){
                    if(user.isUnique(newUser) == true){
                        check = true;
                        try{
                            String query = "insert into user(contactNum,fName,lName,email,address,bDate)" + "values(?,?,?,?,?,?)";
                            PreparedStatement prep = con.prepareStatement(query);
                            prep.setString(1,newUser.getContactNum());
                            prep.setString(2,newUser.getFName());
                            prep.setString(3,newUser.getLName());
                            prep.setString(4,newUser.getEmail());
                            prep.setString(5,newUser.getAddress());
                            prep.setString(6,newUser.getbDate());
                            prep.execute();
                            con.close();
                        }catch(Exception ex){
                            System.out.println("Error: "+ex);
                        }
                    }
                }
                if(check == true) {
                    userList.add(newUser);
                }
            }
        });
    }

    public static void main(String[] args){
        DBConnect connect = new DBConnect();
        GUI menuGUI = new GUI("User System");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
