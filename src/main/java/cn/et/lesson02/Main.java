package cn.et.lesson02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//必须添加SpringBootApplication 启用spring的自动配置功能加入tomcat  这个注解被@EnableAutoConfiguration(靠这个加入tomcat)注解注释  
@SpringBootApplication
//@ComponentScan(xx.xx.xx) 扫描指定包下的文件
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
