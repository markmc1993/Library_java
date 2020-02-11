// Controller class
// Created by Mark McAllister
// Last update 10/02/2020

import java.util.*;

public class Control {
    //create variables for serialized info to be stored in while program is running
    public static HashMap<String, Admin> admins = new HashMap<>();
    public static HashMap<String, VIPMember> vipmembers = new HashMap<>();
    public static HashMap<String, Member> members = new HashMap<>();
    public static HashMap<String, User> users = new HashMap<>();
    public static HashMap<Integer, Book> books = new HashMap<>();
    public static HashMap<Integer, CD> cds = new HashMap<>();
    public static HashMap<Integer, Journal> journals = new HashMap<>();
    public static HashMap<Integer, Video> videos = new HashMap<>();
    public static HashMap<String, LinkedList<Date>> userlogins = new HashMap<>();
    public static HashMap<String, LinkedList<Integer>> loans = new HashMap<>();
    public static HashMap<String, LinkedList<Integer>> loanrequests = new HashMap<>();
    public static HashMap<String, LinkedList<Integer>> loanhistories = new HashMap<>();
    public static HashMap<Integer, Date> loanouts = new HashMap<>();
    public static HashMap<Integer, Date> loanreturns = new HashMap<>();
    public static String userInput;


    public static void main(String[] args) {
        //run deserialization
        Deserialize deser = new Deserialize();
        deser.deserialization();

        //run menu
        Menu menu = new Menu();
        menu.welcomeMenu();


        //run serialization
        Serialize ser = new Serialize();
        ser.Serialization();

        
    }

}
