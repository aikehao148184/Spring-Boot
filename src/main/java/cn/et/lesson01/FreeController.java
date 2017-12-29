package cn.et.lesson01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.et.lesson01.dao.EmpRepository;
/**
 * helloworld例子
 * @author Administrator
 *
 */
@Controller
public class FreeController {
	
	@RequestMapping("/indexFtl")
	public String indexFtl(Model model){
		model.addAttribute("hobbyArr", new String[]{"A","B"});
		return "aaa";
	}
	

}
