package com.raj.hibernate.StudentService;

import java.util.List;

import com.raj.hibernate.DTO.StudentDTO;

public interface StudentServiceImpl {
	
	StudentDTO createStudent(StudentDTO student);
	
	void updateStudent(StudentDTO student);
	
	void deleteStudent(Integer id);
	
	StudentDTO findStudentById(Integer id);
	
	List<StudentDTO> getAllStudents();

}
