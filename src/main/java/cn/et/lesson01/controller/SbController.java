package cn.et.lesson01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.et.lesson01.Emp;
import cn.et.lesson01.dao.EmpRepository;
/**
 * helloworld例子
 * @author Administrator
 *
 */
@RestController

public class SbController {
	/**
	 * 只需要配置application.properties的四要素 即可使用该类
	 *  spring.datasource.url=jdbc:mysql://localhost/food
		spring.datasource.username=root
		spring.datasource.password=123456
		spring.datasource.driver-class-name=com.mysql.jdbc.Driver
	 */
	@Autowired
	JdbcTemplate jdbc;
	/**
	 * 自定义一个接口继承自CrudRepository即可 
	 *   interface EmpRepository extends CrudRepository<操作实体类型, 主键类型>
	 */
	@Autowired
	EmpRepository er;
	/**
	 * 使用jdbctemplate的例子
	 * @param empId
	 * @return
	 */
	@RequestMapping("/emp/{empId}")
	public Map getEmp(@PathVariable String empId){
		List<Map<String, Object>> queryForList = jdbc.queryForList("select * from emp where id="+empId);
		return queryForList.get(0);
	}
	/**
	 * 使用hibernate保存的例子
	 * @return
	 */
	@RequestMapping("/saveEmp")
	public String saveEmp(){
		Emp emp=new Emp();
		emp.setEname("ww");
		emp.setSal(12.4);
		emp.setDeptid(4);
		er.save(emp);
		return "1";
	}
	/**
	 * 使用hibernate查询例子
	 * @return
	 */
	@RequestMapping("/queryemp")
	public Emp querEmp(){
		Emp emp=er.findOne(2);
		return emp;
	}
	
	@RequestMapping("/deleteemp")
	public String deleteEmp(){
		Emp emp = new Emp();
		emp.setId(4);
		er.delete(emp);
		return "OK";
	}
	
}
