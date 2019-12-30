package com.smartdiscover.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
public class User {

    @Id
    private String id;

    @NotNull(message = "First Name is mandatory")
    private String firstName;

    @NotNull(message = "Last Name is mandatory")
    private String lastName;

    @NotNull(message = "Email is mandatory")
    @Email(message = "Not valid email")
    @Indexed(unique=true)
    private String email;

    @NotNull(message = "Phone Number is mandatory")
    private String phone;

    private String address;
}


