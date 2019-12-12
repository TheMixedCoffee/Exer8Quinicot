/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main.java;

/**
 *
 * @author quinicotis_cis21035
 */
public class User {
    private String fName;
    private String lName;
    private String bDate;
    private String email;
    private String contactNum;
    private String address;

    public User(){
        fName = "";
        lName = "";
        bDate = "";
        email = "";
        contactNum = "";
        address = "";
    }

    public User(String fname, String lname, String bdate, String email, String contactNum, String address){
        this.fName = fname;
        this.lName = lname;
        this.bDate = bdate;
        this.email = email;
        this.contactNum = contactNum;
        this.address = address;
    }

    public boolean isUnique(User user) {
        if (user == null) return true;
        if (user instanceof User) {
            User another = (User) user;
            if (this.contactNum.equals(another.getContactNum())) {
                return false;
            }
        }
        return true;
    }

    public void setFName(String name){
        this.fName = name;
    }

    public String getFName(){
        return this.fName;
    }

    public void setLName(String name){
        this.lName = name;
    }

    public String getLName(){
        return this.lName;
    }

    public void setbDate(String bDate){
        this.bDate = bDate;
    }

    public String getbDate(){
        return this.bDate;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setContactNum(String num){
        this.contactNum = num;
    }

    public String getContactNum(){
        return this.contactNum;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }


}
