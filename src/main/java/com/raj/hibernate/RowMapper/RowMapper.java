package com.raj.hibernate.RowMapper;

import org.springframework.stereotype.Service;

import com.raj.hibernate.DTO.StudentDTO;
import com.raj.hibernate.Entity.Student;

@Service
public class RowMapper {
	
	public StudentDTO getStudentDTO(Student student) {
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setFirstName(student.getFirstName());
		studentDTO.setId(student.getId());
		studentDTO.setLastName(student.getLastName());
		studentDTO.setEmail(student.getEmail());
		return studentDTO;
	}
	
	public Student getStudentEntity(StudentDTO studentdto) {
		Student student=new Student();
		student.setEmail(studentdto.getEmail());
		student.setFirstName(studentdto.getFirstName());
		student.setLastName(studentdto.getLastName());
		student.setId(studentdto.getId());
		return student;
	}

}
