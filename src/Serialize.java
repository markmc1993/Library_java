// Serialize class
// Created by Mark McAllister
// Last update 10/02/2020
import java.io.*;

public class Serialize {

    public void Serialization(){
        try {
            FileOutputStream fileOut = new FileOutputStream("admins.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.admins);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("vipmembers.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.vipmembers);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("members.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.members);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("users.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.users);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("books.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.books);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("cds.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.cds);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("journals.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.journals);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("videos.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.videos);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("logins.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.userlogins);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("loans.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.loans);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("loanrequests.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.loanrequests);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("loanhistories.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.loanhistories);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("loanreturns.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.loanreturns);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("loanouts.ser", false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Control.loanouts);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }
}
