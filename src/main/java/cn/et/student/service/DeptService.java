package cn.et.student.service;

import java.util.List;

import cn.et.student.entity.Emp;
import cn.et.student.entity.TreeNode;

public interface DeptService {
	public List<TreeNode> queryTreeNode(Integer pid);
	public List<Emp> queryEmp(Integer id);
}