// Dummy data class
// Created by Mark McAllister
// Last update 10/02/2020
import java.util.*;
public class DummyData {

    PassEncrypt pass = new PassEncrypt();

    public void addData(){
        //Add dummy user data
        User u1 = new User("Paul", "Blart", "pblart1", pass.encrypt("blartattack"), "pblart@mallcop.com");
        Control.users.put(u1.getUserName(), u1);


        User u2 = new User("Jim", "Bo", "jbo2", pass.encrypt("jaybz"), "jibo@bojim.co.uk");
        Control.users.put(u2.getUserName(), u2);

        User u3 = new User("Jane", "Wool", "jwool3", pass.encrypt("password1"), "jawoo@email.com");
        Control.users.put(u3.getUserName(), u3);

        Member m1 = new Member("Frank", "Jones", "fjones4",  pass.encrypt("banana"), "frankiejones@yahoo.com", "a place", "ts45tt", "01234567898", "31111968");
        Control.members.put(m1.getUserName(), m1);

        Member m2 = new Member("Donnie", "Yen", "dyen5" , pass.encrypt("abcdefg"),  "donnieyen@msn.com", "12 made up place", "tg33ts", "09876543215", "10101919");
        Control.members.put(m2.getUserName(), m2);

        Member m3 = new Member("Mary", "Sue", "msue6", pass.encrypt("zyxwv"), "maysue@thing.ac.uk", "a location", "ac45op", "01478523696", "11112001");
        Control.members.put(m3.getUserName(), m3);

        VIPMember s1 = new VIPMember("June", "Doe", "jdoe7", pass.encrypt("abcdefg"), "junifer@eeeeee.com", "another location", "aa45aa", "01111111111", "12112010");
        Control.vipmembers.put(s1.getUserName(), s1);

        VIPMember s2 = new VIPMember("Bobby", "Madden", "bmadden8", pass.encrypt("horses"), "bobert@eeeeee.com", "street street", "bb45wg", "11155599964", "04061983");
        Control.vipmembers.put(s2.getUserName(), s2);

        VIPMember s3 = new VIPMember("Louis", "And", "land9", pass.encrypt("password12"), "loind@email.com", "bla bla bla", "da41ta", "45612378905", "08091943");
        Control.vipmembers.put(s3.getUserName(), s3);

        Admin a1 = new Admin("Mark", "Admin", "ma1001", pass.encrypt("admin1"), "madman@workplace.email");
        Control.admins.put(a1.getAdminID(), a1);


        //Add dummy item data

        Book b1 = new Book(1001, "the book", 1.50, "penguin", true, "568-4-82-469267-0", "alber booksworth", "war", 1854);
        Control.books.put(b1.getStockID(), b1);

        Book b2 = new Book(1002, "the book2: electric boogaloo", 1.75, "penguin", true, "568-4-82-469237-0", "albert booksworth", "drama", 890);
        Control.books.put(b2.getStockID(), b2);

        Book b3 = new Book(1003, "the book3: revenge of the book", 2.25, "penguin", true, "568-4-82-466767-0", "albert booksworth", "fantasy", 368);
        Control.books.put(b3.getStockID(), b3);

        Journal j1 = new Journal(1004, "journal to the centre of the earth", 5.50, "scopus", true, "6248-6458", 56, "10092019", "archaeology", 64);
        Control.journals.put(j1.getStockID(), j1);

        Journal j2 = new Journal(1005, "an unexpected journal", 5.50, "scopus", true, "6248-6529", 48, "12122009", "geography", 52);
        Control.journals.put(j2.getStockID(), j2);

        Journal j3 = new Journal(1006, "bill and teds bogus journal", 5.50, "scopus", true, "6248-6248", 12, "25032013", "philosophy", 18);
        Control.journals.put(j3.getStockID(), j3);

        CD c1 = new CD(1007, "see dee", 0.50, "dim jam", true, "2:25", "album", 12, "slam shoddy", "jewelled case");
        Control.cds.put(c1.getStockID(), c1);

        CD c2 = new CD(1008, "crayon design", 0.75, "jim jam", true, "1:75", "record", 8, "phill.i.am", "sleeve");
        Control.cds.put(c2.getStockID(), c2);

        CD c3 = new CD(1009, "another disk in the tray", 1.00, "jam jam", true, "2:00", "album", 15, "fredward mercedes", "jewelled case");
        Control.cds.put(c3.getStockID(), c3);

        Video v1 = new Video(1010, "video killed the radio star", 2.20, "mirrormax", true, "2:50", "dvd", "musical", "plastic box");
        Control.videos.put(v1.getStockID(), v1);

        Video v2 = new Video(1011, "steal this video", 3.60, "legenderry", true, "3:25", "blu ray", "crime", "plastic box");
        Control.videos.put(v2.getStockID(), v2);

        Video v3 = new Video(1012, "eat this tape", 1.80, "disnee", true, "1:75", "betamax", "action", "cardboard box");
        Control.videos.put(v3.getStockID(), v3);


        //add all vipmembers and members to loanrequests, loans and loanhistories
        for (Map.Entry<String, VIPMember> entry : Control.vipmembers.entrySet()) {
            Control.loanrequests.put(entry.getKey(), new LinkedList<>());
            Control.loans.put(entry.getKey(), new LinkedList<>());
            Control.loanhistories.put(entry.getKey(), new LinkedList<>());
            Control.userlogins.put(entry.getKey(), new LinkedList<>());
        }
        for (Map.Entry<String, Member> entry : Control.members.entrySet()) {
            Control.loanrequests.put(entry.getKey(), new LinkedList<>());
            Control.loans.put(entry.getKey(), new LinkedList<>());
            Control.loanhistories.put(entry.getKey(), new LinkedList<>());
            Control.userlogins.put(entry.getKey(), new LinkedList<>());

        }

        for(Map.Entry<String, User> entry: Control.users.entrySet()){
            Control.userlogins.put(entry.getKey(), new LinkedList<>());
        }
        //run serialization
        Serialize ser = new Serialize();
        ser.Serialization();
    }
}
