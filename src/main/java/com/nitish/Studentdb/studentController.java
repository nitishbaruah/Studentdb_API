package com.nitish.Studentdb;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController //important annotation to make rest API, it defines this class ia an API.
public class studentController {
    Map<Integer,Student> db= new HashMap<>();

    @PostMapping ("/add_student") //POST endpoint
    public String addStudent(@RequestBody Student student){
        if(student==null) return "Invalid Input";
        db.put(student.getEnrollNo(),student);
        return "Successfully ADDED";
    }

    @GetMapping ("/get_student") //GET endpoint
    public Student getStudent(@RequestParam("q") int enrollNo){

        return db.get(enrollNo);
    }

}
