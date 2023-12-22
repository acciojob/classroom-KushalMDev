package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

	HashMap<String,Student> studentMapping =new HashMap<>();
	HashMap<String,Teacher> teacherMapping =new HashMap<>();
	HashMap<String,List<String>> teacherStudentMapping =new HashMap<>();
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentMapping.put(student.getName(),student);
	}
	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherMapping.put(teacher.getName(), teacher);
	}
	public void saveStudentTeacherMapping(String student, String teacher) {
		// TODO Auto-generated method stub
		Student s=studentMapping.get(student);
		Teacher t=teacherMapping.get(teacher);
		List<String> list=teacherStudentMapping.getOrDefault(teacher, new ArrayList<>());
		list.add(s.getName());
		teacherStudentMapping.put(teacher, list);
	}
	public Student getStudentName(String name) {
		// TODO Auto-generated method stub
		return studentMapping.get(name);
	}
	public Teacher getTeacherName(String name) {
		// TODO Auto-generated method stub
		return teacherMapping.get(name);
	}
	public List<String> getStudentsByTeacherName(String teacher) {
		// TODO Auto-generated method stub
		return teacherStudentMapping.get(teacher);
	}
	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		for(String student:studentMapping.keySet()) {
			list.add(student);
		}
		return list;
	}
	public void deleteTeacherByName(String teacher) {
		// TODO Auto-generated method stub
		teacherMapping.remove(teacher);
		for(String student:teacherStudentMapping.get(teacher)){
			studentMapping.remove(student);
		}
		teacherStudentMapping.remove(teacher);
	}
	public void deleteAllTeachers() {
		// TODO Auto-generated method stub
		teacherMapping.clear();
		for(String teacher:teacherStudentMapping.keySet()){
			List<String> li=teacherStudentMapping.get(teacher);
			for(String str:li){
				studentMapping.remove(str);
			}
		}
		teacherStudentMapping.clear();
	}
	
	
	
}
