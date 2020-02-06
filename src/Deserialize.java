import java.io.*;
import java.util.HashMap;

//To be used to deserialize the serialized data or add dummy data if serialization has not occured
public class Deserialize {

    public void deserialization(){
        File adminsfile = new File("admins.ser");
        if (adminsfile.exists()){

            try {
                FileInputStream fileIn = new FileInputStream("admins.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.admins = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".Admin class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("staffusers.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.vipmembers = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".StaffUser class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("fullmembers.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.members = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".FullMember class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("users.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.users = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".User class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("books.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.books = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".Book class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("cds.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.cds = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".CD class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("journals.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.journals = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".Journal class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("videos.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.videos = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".Video class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("logins.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.userlogins = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".Video class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("loans.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.loans = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".Video class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("loanrequests.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.loanrequests = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".Video class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("loanhistories.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.loanhistories = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println("class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("loanreturns.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.loanreturns = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".class not found.");
                c.printStackTrace();
                return;
            }


            try {
                FileInputStream fileIn = new FileInputStream("loanouts.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Control.loanouts = (HashMap) in.readObject();
                in.close();
            }catch(IOException i) {
                i.printStackTrace();
                return;
            }catch(ClassNotFoundException c) {
                System.out.println(".class not found.");
                c.printStackTrace();
                return;
            }
        }
        else{
            DummyData dummy = new DummyData();
            dummy.addData();
        }
    }

}
