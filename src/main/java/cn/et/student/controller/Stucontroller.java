package cn.et.student.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.et.student.entity.Result;
import cn.et.student.entity.Student;
import cn.et.student.service.StudentService;
import cn.et.student.utils.PageTools;

@Controller
public class Stucontroller {
	@Autowired
	StudentService ser;
	@ResponseBody
	@RequestMapping("/query")
	public PageTools queryStudent(String sname,Integer page,Integer rows){
		return ser.queryStudent(sname,page,rows);
	}
	
	@ResponseBody
	@RequestMapping(value="/delete/{sid}",method=RequestMethod.DELETE)
	public Result deletestudent(@PathVariable Integer sid){
		Result re = new Result();
		re.setCode(0);
		try {
			ser.deleteStudent(sid);
		} catch (Exception e) {
			re.setCode(1);
			re.setMessage(e.getMessage());
		}
		return re;
	}
	
	@ResponseBody
	@RequestMapping(value="/update/{sid}",method=RequestMethod.PUT)
	public Result updatestudent(@PathVariable Integer sid,Student student){
		student.setSid(sid);
		student.setGid(1);
		Result re = new Result();
		re.setCode(0);
		try {
			ser.updateStudent(student);
		} catch (Exception e) {
			re.setCode(1);
			re.setMessage(e.getMessage());
		}
		return re;
	}
	
	@ResponseBody
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savestudent(Student student,MultipartFile file) throws Exception{
		int maxSid = ser.MaxSid();
		student.setSid(maxSid);
		student.setGid(1);
		ser.saveStudent(student);
		String fileName = file.getOriginalFilename();
		File file2 = new File("E:\\html\\"+fileName);
		file.transferTo(file2);
		return null;
	}
}









