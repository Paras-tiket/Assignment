package com.pxp.springbootmongodbmysql.controller;

import com.pxp.springbootmongodbmysql.model.StudentModel;
import com.pxp.springbootmongodbmysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "APPLICATION IS RUNNING.";
    }

    @RequestMapping(value = "createresource", method = RequestMethod.POST)
    public String createStudent(@RequestBody StudentModel studentModel){
        return studentService.createResource(studentModel);
    }

    @RequestMapping(value = "readresources", method = RequestMethod.GET)
    public List<StudentModel> readResources(){
        return studentService.readResources();
    }

    @RequestMapping(method = RequestMethod.GET, value="/readresources/{email}")
    public List<StudentModel> updateSubject(@PathVariable String email)
    {
       return studentService.getStudent(email);
    }

    @RequestMapping(value = "updateresource", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody StudentModel studentModel){
        return studentService.updateResource(studentModel);
    }

    @RequestMapping(value = "deleteresource", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody StudentModel studentModel){
        return studentService.deleteResource(studentModel);
    }
}
