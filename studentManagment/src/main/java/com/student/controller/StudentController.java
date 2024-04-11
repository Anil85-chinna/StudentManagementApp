package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/All")
	public List<Student> dispalyAllStudents() {
		List<Student> studentss = studentService.getAllStudents();
		return studentss;
	}

	@PostMapping("/save")
	public ResponseEntity<?> createStudentRecod(@RequestBody Student student) {
		System.out.println(student);
		System.out.println(student.toString());
		studentService.createNewStudent(student);
		return ResponseEntity.ok("is created in Database");
	}

	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") int id) {
		Student findExcitedStudent = studentService.getStudentById(id);
		if (findExcitedStudent == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Student details with id " + id + " dose not exist");

		} else {
			return ResponseEntity.ok(findExcitedStudent);
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateById(@PathVariable(name = "id") int id,@RequestBody Student student) {
		Student isUpdatedStudent = studentService.updatedByid(id, student);
		if (isUpdatedStudent == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Student details with id " + id + " dose not exist");

		} else {
			
			return ResponseEntity.ok(isUpdatedStudent);
		}

	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable(name="id")int id){
		Student isDeletedStudent = studentService.deleteStudentById(id);
		if(isDeletedStudent == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student details with Id given "+id+" Not Found");
		}
		else {
			return ResponseEntity.ok(isDeletedStudent+"The Student details With id give is deleted");
		}
		
	}
}
