package com.nitish.Studentdb;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class studentRepository {
    Map<Integer,Student> db=new HashMap<>();
    //************ GET method ***************************
    //GET Student detail by Enroll ID
    public Student getStudent(int id){
        if(!db.containsKey(id)) return null;
        return db.get(id);
    }
    //GET Student detail by Name
    public Student getStudentByName(String name){
        int enrollId=0;
        for(int enrollNo:db.keySet()){
            if(db.get(enrollNo).getName().equals(name)) {
                enrollId=enrollNo;
                break;
            }
        }
        if(enrollId==0) return null;
        return db.get(enrollId);
    }

    //************ ADD/POST method ***************************
    // ADD Method
    public String addStudent(Student student){
        db.put(student.getEnrollNo(), student);
        return "Successfully Added";
    }

    //************ DELETE method ***************************
    // Delete Method
    public String deleteStudent(int id){
        if(!db.containsKey(id)) return null;
        db.remove(id);
        return "Successfully removed";
    }
    //************ UPDATE/PUT method ***************************
    // Update Method , update age
    public String updateStudentAge(int id, int age){
        if(!db.containsKey(id)) return null;
        db.get(id).setAge(age);
        return "Updated";
    }
    // Update Method , update age
    public String updateStudentName(int id, String name){
        if(!db.containsKey(id)) return null;
        db.get(id).setName(name);
        return "Updated";
    }
    // Update Method , update age
    public String updateStudentCountry(int id, String country){
        if(!db.containsKey(id)) return null;
        db.get(id).setCountry(country);
        return "Updated";
    }
}
