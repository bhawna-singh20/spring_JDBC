package com.spring.JDBC.service;

import com.spring.JDBC.model.Student;
import com.spring.JDBC.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStd(Student s){
        repo.save(s);
    }
    public List<Student> getStudent(){
        return repo.findAll();
    }
    public void addService(Student s){
        System.out.println("created");
    }
}
