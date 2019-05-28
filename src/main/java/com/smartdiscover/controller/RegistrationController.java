package com.smartdiscover.controller;

import com.smartdiscover.impl.RegistrationImpl;
import com.smartdiscover.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin
public class RegistrationController {

    @Autowired
    private RegistrationImpl registrationImpl;

    @PostMapping(path = "/registerUser")
    public ResponseEntity<HashMap<String, Object>> registerUser(@RequestBody User user) throws Exception{
        HashMap<String, Object> resp = new HashMap<>();
        try {
            registrationImpl.registerUser(user);
        }catch(ConstraintViolationException e){
            HashMap<String, String> messages = new HashMap<>();
            e.getConstraintViolations().stream().forEach(constraintViolation -> {
                messages.put(constraintViolation.getPropertyPath().toString(),constraintViolation.getMessage());
            });
            resp.put("error",true);
            resp.put("messages",messages);
        }
        resp.put("user",user);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/getUser" )
    public ResponseEntity<User> getUser(@RequestParam("id") String id) throws Exception {
        User user = registrationImpl.getUserData(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAllUser" )
    public ResponseEntity<List<User>> getAllUser() throws Exception {
        List<User> users = registrationImpl.getAllUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser" )
    public ResponseEntity<HashMap> deleteUser(@RequestParam("id") String id) throws Exception {
        registrationImpl.deleteUser(id);
        HashMap<String,String> resp = new HashMap<>();
        resp.put("message","User is successfully deleted");
        return new ResponseEntity<HashMap>(resp,HttpStatus.OK);
    }
}
