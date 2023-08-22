package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo sr;
	public Student saveinfo(Student ss)
	{
		return sr.save(ss);
	}
	public Optional<Student> gettinfo(int id)
	{
		return sr.findById(id);
	}
	public List<Student>showinfo()
	{
		return sr.findAll();
	}
	public Student changeinfo(Student ss)
	{ 
		return sr.saveAndFlush(ss);
	}
	public void deletepid(int id)
	{
		sr.deleteById(id);
	}
	public String updatebyid(int id,Student ss)
	{
		sr.saveAndFlush(ss);
		if(sr.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid Id";
		}
	}
	
}
