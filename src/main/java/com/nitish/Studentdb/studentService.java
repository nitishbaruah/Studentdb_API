package com.nitish.Studentdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    @Autowired
    studentRepository studentRepository;

    //Add Service
    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }
    //Get Service
    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }
    public Student getStudent(int id){
        return studentRepository.getStudent(id);
    }

    //Delete service
    public String deleteStudent(int id){
        return studentRepository.deleteStudent(id);
    }

    //PUT Services
    public String updateStudentAge(int id, int age){
        return studentRepository.updateStudentAge(id,age);
    }
    public String updateStudentName(int id, String name){
        return studentRepository.updateStudentName(id,name);
    }
    public String updateStudentCountry(int id, String country){
        return studentRepository.updateStudentCountry(id,country);
    }
}
