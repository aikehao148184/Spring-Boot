package cn.et.student.service;

import cn.et.student.entity.Student;
import cn.et.student.utils.PageTools;

public interface StudentService {

	public abstract PageTools queryStudent(String sname,Integer page,Integer rows);
	
	public void deleteStudent(Integer sid);
	
	public void updateStudent(Student stu);
	
	public int MaxSid();
	
	public void saveStudent(Student stu);

}