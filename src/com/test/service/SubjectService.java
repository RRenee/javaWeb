package com.test.service;

import java.util.List;

import com.test.po.Subject;
import com.test.po.SubjectInf;
import com.test.util.Page;
import com.test.util.PageResult;


public interface SubjectService {
	
	//public boolean saveSubject(Subject subject);
	
	//public PageResult querySubjectByPage(Page page);
	
	public Subject showSubjectByID(int subject_id);
	
	//public List<Subject> showSubjectByClass(int subject_class);
	
	// 更新试题信息
	//public void updateSubject(Subject subject);
	
	// 删除试题信息
	//public void deleteSubject(int subject_id);
	
	//模糊查询试题信息
	//public PageResult likeQueryBySubjectTitle(String subject_title,Page page);
	
	//获取所有试题
	public List<Subject> showAllSubject();
	public int numClasses();
	public int numSubjectByClasses(int classes_id);
	public List<SubjectInf> findAllSubject();
	public Subject findSubjectByClasses(int number);
	//计算学生得分
	//public int accountResult(List<Integer> subject_ids,List<String> studentAnswers);
}
