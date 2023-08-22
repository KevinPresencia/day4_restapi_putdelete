package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class ApiController {
	@Autowired
	StudentService sser;
	@PostMapping("addstudent")
	public Student add(@RequestBody Student ss)
	{
		return sser.saveinfo(ss);
	}
	@GetMapping("showdetails")
	public List<Student>show()
	{
		return sser.showinfo();
	}
	@GetMapping("get/{id}")
	public Optional<Student>getinfo(@PathVariable int id)
	{
		return sser.gettinfo(id);
	}
	@PutMapping ("update")
	public Student modify(@RequestBody Student ss)
	{
		return sser.changeinfo(ss);
	}
	@DeleteMapping("delid/{id}")
	public void deletemyid(@PathVariable int id)
	{
		sser.deletepid(id);
	}
	@PutMapping("updateid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Student ss)
	{
		return sser.updatebyid(id,ss);
	}
}
