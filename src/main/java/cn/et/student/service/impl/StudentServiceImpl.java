package cn.et.student.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.student.dao.StudentMapper;
import cn.et.student.entity.Student;
import cn.et.student.entity.StudentExample;
import cn.et.student.service.StudentService;
import cn.et.student.utils.PageTools;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentMapper sm;
	/* (non-Javadoc)
	 * @see cn.et.food.service.impl.StudentService#queryStudent(java.lang.String)
	 */
	public PageTools queryStudent(String sname,Integer page,Integer rows){
		if(sname==null){
			sname="";
		}
		//����sql����ѯ�ܼ�¼��
		StudentExample se = new StudentExample();
		se.createCriteria().andSnameLike("%"+sname+"%");
		int total = (int)sm.countByExample(se);
		// limit ��ʼλ��,�ܼ�¼��
		PageTools pts=new PageTools(page, total, rows);
		RowBounds rb = new RowBounds(pts.getStartIndex(),rows);
		List<Student> list = sm.selectByExampleWithRowbounds(se, rb);
		pts.setRows(list);
		return pts;
	}
	
	public void deleteStudent(Integer sid){
		sm.deleteByPrimaryKey(sid);
	}
	
	public void updateStudent(Student stu){
		sm.updateByPrimaryKey(stu);
	}
	
	public int MaxSid(){
		int Sid = sm.selectMaxSid();
		System.out.println(Sid);
		return Sid;
	}
	
	public void saveStudent(Student stu){
		sm.insert(stu);
	}
}
