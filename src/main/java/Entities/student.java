package Entities;

import addressValid.IsvalidAddress;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ahmed on 5/22/2017.
 */
public class student {

    private int id;
    @Size(min = 3, max = 5, message = "Username Size Not Available ")
    private String username;
    private String password;
    @IsvalidAddress(ListOfAddress = "tanta|cairo|shebin" )
    private String address;
    @Max(value = 1000 , message = "NUmber <1000 ")
    private Long mobile;
    @Past(message ="should be in the past ")
    private Date birthDate;

    public student() {
    }

    public student(int id, String username, String password, String address, Long mobile, Date birthDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
        this.mobile = mobile;
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }
}
