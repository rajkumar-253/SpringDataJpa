package com.raj.hibernate.StudentRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.raj.hibernate.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{


}
