package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = studentRepo.findAll();
		return students;
	}

	@Override
	public void createNewStudent(Student student) {
		studentRepo.save(student);

	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> studentById = studentRepo.findById(id);
		if (studentById.isEmpty()) {
			return null;
		} else {
			return studentById.get();
		}
	}

	@Override
	public Student updatedByid(int id, Student student) {
		Student existStudent = getStudentById(id);
		if (existStudent == null) {
			return null;
		} else {
			existStudent.setName(student.getName());
			existStudent.setAddress(student.getAddress());
			existStudent.setPhoneNo(student.getPhoneNo());

			Student updatedStudent = studentRepo.save(existStudent);
			return updatedStudent;
		}
	}

	@Override
	public Student deleteStudentById(int id) {
		Student deleteStudent = getStudentById(id);
		if (deleteStudent == null) {
			return null;
		} else {
			studentRepo.deleteById(id);
			return deleteStudent;
		}
	}

}
