package com.gl.lab6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.lab6.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
}
