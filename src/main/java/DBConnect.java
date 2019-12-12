package main.java;
import java.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://3306/userDB","root","");
            stm = con.createStatement();
        }catch(Exception ex){
            System.out.println("Error:" +ex);
        }
    }
}
