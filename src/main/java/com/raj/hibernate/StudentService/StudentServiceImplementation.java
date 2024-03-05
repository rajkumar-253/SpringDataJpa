package com.raj.hibernate.StudentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.hibernate.DTO.StudentDTO;
import com.raj.hibernate.Entity.Student;
import com.raj.hibernate.RowMapper.RowMapper;
import com.raj.hibernate.StudentRepo.StudentRepo;

@Service
public class StudentServiceImplementation implements StudentServiceImpl {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private RowMapper rowMapper1;

	@Override
	public StudentDTO createStudent(StudentDTO studentDTO) {
		Student student= rowMapper1.getStudentEntity(studentDTO);
		Student save = studentRepo.save(student);
		StudentDTO stuDTO=rowMapper1.getStudentDTO(save);
		return stuDTO;
	}

	@Override
	public void updateStudent(StudentDTO studentdto) {
		int updateId=studentdto.getId();
		Student student=rowMapper1.getStudentEntity(studentdto);
		student.setId(updateId);
		studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public StudentDTO findStudentById(Integer id) {
			Student byId = studentRepo.findById(id).get();
			StudentDTO studentDTO=rowMapper1.getStudentDTO(byId);
			return studentDTO;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		 List<Student> all = studentRepo.findAll();
		 List<StudentDTO> studentDTO=new ArrayList<>();
		 for(Student student:all) {
			StudentDTO studentDTO2 = rowMapper1.getStudentDTO(student);
			studentDTO.add(studentDTO2);
		 }
		 return studentDTO;
		 
	}

}
