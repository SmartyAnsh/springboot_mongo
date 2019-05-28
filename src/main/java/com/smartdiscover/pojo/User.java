package com.smartdiscover.pojo;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.index.Indexed;

public class User {

    @Id
    private String id;

    /**
     * Person identification info
     **/
    @NotNull(message = "First Name is mandatory")
    private String firstName;

    private String middleName;

    @NotNull(message = "Last Name is mandatory")
    private String lastName;

    @Email(message = "Not valid email")
    @Indexed(unique=true)
    private String email;

    @NotNull(message = "Phone Number is mandatory")
    private String phone;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


