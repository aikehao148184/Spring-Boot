package cn.et.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.student.entity.Emp;
import cn.et.student.entity.TreeNode;
import cn.et.student.service.DeptService;

@Controller
public class Deptcontroller {
	@Autowired
	DeptService dept;
	@ResponseBody
	@RequestMapping("/querydept")
	public List<TreeNode> queryStudent(Integer id){
		if(id==null){
			id=0;
		}
		return dept.queryTreeNode(id);
	}
	
	@ResponseBody
	@RequestMapping("/queryemp")
	public List<Emp> queryemp(Integer id){
		return dept.queryEmp(id);
	}
	
}









