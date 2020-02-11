// Member class
// Created by Mark McAllister
// Last update 10/02/2020
public class Member extends User{

    private String address;
    private String postcode;
    private String phoneNo;
    private String dob;


    public Member(String firstName, String lastName, String userName, String password, String email, String address, String postcode, String phoneNo, String dob) {
        super(firstName, lastName, userName, password, email);
        this.address = address;
        this.postcode = postcode;
        this.phoneNo = phoneNo;
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
