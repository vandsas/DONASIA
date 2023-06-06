/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author bagas
 */
public class DataUser {
    private String Fullname;
    private String Username;
    private String PhoneNumber;
    private String DateOfBirth;
    private String EmailUser;
    private String Password;

    public DataUser(String Fullname, String Username, String PhoneNumber, String DateOfBirth, String EmailUser, String Password) {
        this.Fullname = Fullname;
        this.Username = Username;
        this.PhoneNumber = PhoneNumber;
        this.DateOfBirth = DateOfBirth;
        this.EmailUser = EmailUser;
        this.Password = Password;
    }

    public DataUser(String Password){
        this.Password = Password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getEmailUser() {
        return EmailUser;
    }

    public void setEmailUser(String EmailUser) {
        this.EmailUser = EmailUser;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
