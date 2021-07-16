package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public String addStudent(Student student){
        studentRepository.insert(student);
        return "Success";
    }

    public String updateStudent(Student student){
        studentRepository.save(student);
        return "Success";
    }

    public String deleteStudent(String id){
        if(studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            System.out.println("deleted the student record with ID: " + id);
            return "Success";
        }
        else
        {
            System.out.println("No student record with ID: " + id);
            return "Failure";
        }
    }
}
