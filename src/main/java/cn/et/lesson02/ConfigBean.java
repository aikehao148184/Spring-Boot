package cn.et.lesson02;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class ConfigBean {
	/**
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidStatView(){
		ServletRegistrationBean ser = new ServletRegistrationBean();
		ser.setName("DruidStatView");
		StatViewServlet view = new StatViewServlet();
		ser.setServlet(view);
		String url = "/druid/*";
		List<String> urll = new ArrayList<String>();
		urll.add(url);
		ser.setUrlMappings(urll);
		LinkedHashMap<String, String> user = new LinkedHashMap<String, String>();
		user.put("loginUsername", "admin");
		user.put("loginPassword","123456");
		ser.setInitParameters(user);
		return ser;
	}
}
