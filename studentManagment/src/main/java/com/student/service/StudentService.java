package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public void createNewStudent(Student student);
	public Student getStudentById(int id);
	public Student updatedByid(int id,Student student);
	public Student deleteStudentById(int id);
	

}
