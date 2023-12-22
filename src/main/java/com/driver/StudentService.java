package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		studentRepository.saveTeacher(teacher);
	}

	public void saveStudentTeacherMapping(String student, String teacher) {
		// TODO Auto-generated method stub
		studentRepository.saveStudentTeacherMapping(student,teacher);
	}

	public Student getStudentName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentName(name);
		//return null;
	}

	public Teacher getTeacherByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.getTeacherName(name);
	}

	public List<String> getStudentsByTeacherName(String teacher) {
		// TODO Auto-generated method stub
		return studentRepository.getStudentsByTeacherName(teacher);
	}

	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.getAllStudents();
	}

	public void deleteTeacherByName(String teacher) {
		// TODO Auto-generated method stub
		studentRepository.deleteTeacherByName(teacher);
	}

	public void deleteAllTeachers() {
		// TODO Auto-generated method stub
		studentRepository.deleteAllTeachers();
	}
	
	

}
