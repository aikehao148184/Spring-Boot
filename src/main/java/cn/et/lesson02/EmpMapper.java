package cn.et.lesson02;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.et.lesson02.entity.Emp;

@Mapper
public interface EmpMapper {
	@Select("select * from emp")
	List<Emp> queryAll();
	
	@Select("select * from emp where id=#{0}")
	Emp queryId(Integer id);
}
