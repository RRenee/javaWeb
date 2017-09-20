package com.test.dao;

import java.util.List;
import com.test.po.Subject;
import com.test.po.SubjectInf;
import com.test.util.Page;

public interface SubjectDAO {
	//public void addSubject(Subject subject);//保存方法，用来保存试题
	
	//public Subject findSubjectByTitle(String subject_title);//根据试题标题查找试题
	
	//public List<Subject> findSubjectByPage(Page page);//分页查询试题
	
	//public int findSubjectCount();//查询试题总量
	public Subject findSubjectByClasses(int subject_class);
	public Subject findSubjectByID(int subject_id);//根据试题ID查找试题
	public int numClasses();
	public int numSubjectByClasses(int classes_id);
	
	//public List<Subject> findSubjectByClass(int subject_class);//根据试题类型查找试题
	
	//public void updateSubject(Subject subject);//更新方法，用来更新试题
	
	//public void deleteSubject(int subject_id);//根据试题ID删除试题
	
	//public List<Subject> likeQueryByTitle(String subjectTitle,Page page);//根据试题标题模糊查询试题
	
	//public int findLinkQueryCount(String subject_title);//查询模糊记录数
	
	public List<Subject> showAllSubject();//取出记录
	public List<SubjectInf> findAllSubject();

}
