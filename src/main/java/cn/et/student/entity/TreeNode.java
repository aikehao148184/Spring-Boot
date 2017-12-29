package cn.et.student.entity;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	//�ڵ��id
	private int id;
	//�ڵ�����
	private String text;
	//�Ƿ�չ������ڵ�  closed ��չ��
	private String state="closed";
	private List<TreeNode> deptList=new ArrayList<TreeNode>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<TreeNode> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<TreeNode> deptList) {
		this.deptList = deptList;
	}
	
}
