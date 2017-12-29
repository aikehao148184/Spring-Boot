package cn.et.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.DeptMapper;
import cn.et.student.dao.EmpMapper;
import cn.et.student.entity.Dept;
import cn.et.student.entity.DeptExample;
import cn.et.student.entity.Emp;
import cn.et.student.entity.EmpExample;
import cn.et.student.entity.TreeNode;
import cn.et.student.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptMapper dept;
	@Autowired
	EmpMapper emp;
	
	public List<TreeNode> queryTreeNode(Integer pid){
		DeptExample de = new DeptExample();
		de.createCriteria().andPidEqualTo(pid);
		List<Dept> sele = dept.selectByExample(de);
		ArrayList<TreeNode> arrayList = new ArrayList<TreeNode>();
		for(Dept s:sele){
			TreeNode tree = new TreeNode();
			tree.setId(s.getDid());
			tree.setText(s.getDname());
			if(queryTreeNode(s.getDid()).size()==0){
				tree.setState("open");
			}
			arrayList.add(tree);
		}
		return arrayList;
	}
	
	public List<Emp> queryEmp(Integer id){
		EmpExample em = new EmpExample();
		if(id!=null)
			em.createCriteria().andDidEqualTo(id);
		return emp.selectByExample(em);
	}
}
