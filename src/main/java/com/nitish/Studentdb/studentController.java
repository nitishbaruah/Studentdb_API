package com.nitish.Studentdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController //important annotation to make rest API, it defines this class ia an API.
public class studentController {
    //Map<Integer,Student> db= new HashMap<>();

    @Autowired
    studentService studentService;

    //Post
    @PostMapping ("/add_student") //POST endpoint
    public ResponseEntity addStudent(@RequestBody Student student){ //requestBody instead of taking single argument taking student
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.CREATED);
    }

    //Get
    @GetMapping ("/get_student") //GET endpoint
    public ResponseEntity getStudent(@RequestParam("q") int enrollNo){  //request param q=enrollNo
        Student student=studentService.getStudent(enrollNo);
        if(student==null) return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity(student, HttpStatus.FOUND);
    }
    @GetMapping ("/get_studentByName") //GET endpoint
    public ResponseEntity getStudentByName(@RequestParam("name") String name){  //request param q=enrollNo
        Student student=studentService.getStudentByName(name);
        if(student==null) return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity(student, HttpStatus.FOUND);
    }

    // Delete
    @DeleteMapping ("/delete_student") //delete endpoint
    public ResponseEntity deleteStudent(@RequestParam("q") int enrollNo){
        String response= studentService.deleteStudent(enrollNo);
        if(response==null) return new ResponseEntity("Student Doesn't Exist.", HttpStatus.NOT_FOUND);
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    //Put
    @PutMapping ("/update_studentAge")
    public ResponseEntity updateAge(@RequestParam("q") int enrollNo, @RequestParam("age") int age){
        String response=studentService.updateStudentAge(enrollNo,age);
        if(response==null) return new ResponseEntity("Student doesn't exist.",HttpStatus.NOT_FOUND);
        return new ResponseEntity(response,HttpStatus.FOUND);
    }

    @PutMapping ("/update_studentName")
    public ResponseEntity updateName(@RequestParam("q") int enrollNo, @RequestParam("name") String name){
        String response=studentService.updateStudentName(enrollNo,name);
        if(response==null) return new ResponseEntity("Student doesn't exist.",HttpStatus.NOT_FOUND);
        return new ResponseEntity(response,HttpStatus.FOUND);
    }

    @PutMapping ("/update_studentCountry")
    public ResponseEntity updateCountry(@RequestParam("q") int enrollNo, @RequestParam("country") String country){
        String response=studentService.updateStudentCountry(enrollNo,country);
        if(response==null) return new ResponseEntity("Student doesn't exist.",HttpStatus.NOT_FOUND);
        return new ResponseEntity(response,HttpStatus.FOUND);
    }

}
