package cn.et.lesson02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson02.EmpMapper;
import cn.et.lesson02.entity.Emp;
/**
 * helloworld例子
 * @author Administrator
 *
 */
@RestController

public class SbController {
	
	@Autowired
	EmpMapper emp;
	
	@RequestMapping("/queryall")
	public List<Emp> queryall(){
		List<Emp> queryAll = emp.queryAll();
		return queryAll;
	}
	
	
}
