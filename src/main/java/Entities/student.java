package Entities;


import addressValid.IsvalidAddress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

// ----------- (filter) ignore Null Values from Json --------
@JsonInclude(JsonInclude.Include.NON_NULL)
// --------- to ignore specific information about web service and json --------
@JsonIgnoreProperties({"id", "student_mobile"})
//----------- to order json --------------------
@JsonPropertyOrder({"student_name", "student_password", "student_birthdate", "student_mobile"})
@Entity
@Table
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 3, max = 5, message = "Username Size Not Available ")
    //----- to name json key  -------
    @JsonProperty("student_name")
    private String username;

    @JsonProperty("student_password")
    private String password;
    @IsvalidAddress(ListOfAddress = "tanta|cairo|shebin")
    @JsonProperty("student_address")
    private String address;

    @Max(value = 1000, message = "NUmber <1000 ")
    @JsonProperty("student_mobile")
    private Long mobile;

//    @Past(message = "should be in the past ")
    @JsonProperty("student_birthdate")
    private Date birthDate;

    public student() {
    }

    public student( String username, String password, String address, Long mobile, Date birthDate) {

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
