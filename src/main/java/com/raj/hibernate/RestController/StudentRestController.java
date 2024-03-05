package com.raj.hibernate.RestController;

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
import org.springframework.web.bind.annotation.RestController;

import com.raj.hibernate.DTO.StudentDTO;
import com.raj.hibernate.StudentService.StudentServiceImplementation;

@RestController
public class StudentRestController {
	@Autowired
	private StudentServiceImplementation studentServiceImplementation;
	
	@PostMapping("createStudent")
	public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {
		 StudentDTO student2 = studentServiceImplementation.createStudent(student);
		 return ResponseEntity.status(HttpStatus.CREATED).body(student2);
	}
	
	
	@PutMapping("updateStudent")
	public ResponseEntity<String> updateStudent(@RequestBody StudentDTO student) {
		 studentServiceImplementation.updateStudent(student);
		 return ResponseEntity.ok().body("Updated successfully");
	}
	
	
	@DeleteMapping("deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		studentServiceImplementation.deleteStudent(id);
		return ResponseEntity.ok().body("Deleted Successfully");
	}
	
	
	@GetMapping("findStudentById/{id}")
	public ResponseEntity<StudentDTO> findStudentById(@PathVariable Integer id) {
		 StudentDTO studentById = studentServiceImplementation.findStudentById(id);
		 return ResponseEntity.ok().body(studentById);
	}
	
	
	@GetMapping("getStudents")
	public ResponseEntity<List<StudentDTO>> getStudents(){
		 List<StudentDTO> allStudents = studentServiceImplementation.getAllStudents();
		 return ResponseEntity.ok().body(allStudents);
	}

}
