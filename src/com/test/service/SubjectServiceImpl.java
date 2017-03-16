package com.test.service;

import java.util.List;

import com.test.dao.SubjectDAO;
import com.test.dao.SubjectDAOImpl;
import com.test.po.Subject;
import com.test.po.SubjectInf;
import com.test.util.Page;
import com.test.util.PageResult;
import com.test.util.PageUtil;

public class SubjectServiceImpl implements SubjectService{
	private SubjectDAO subjectDAO =  new SubjectDAOImpl();
	/*
	public boolean saveSubject(Subject subject) {
		String subject_title = subject.getSubject_title();
		if(subjectDAO.findSubjectByTitle(subject_title) == null){ //如果该试题标题不存在，允许添加
			subjectDAO.addSubject(subject);
			return true;
		}else {
			return false;
		}
	}

	public PageResult querySubjectByPage(Page page) {
		page = PageUtil.createPage(page.getEveryPage(),
				subjectDAO.findSubjectCount(),page.getCurrentPage());//根据总记录数创建分页信息
		List<Subject> list = subjectDAO.findSubjectByPage(page);//通过分页信息取得试题
		PageResult result = new PageResult(page,list);//封装分页信息和记录信息，返回给调用处
		return result;
	}

	public Subject showSubjectByID(int subject_id) {
		return subjectDAO.findSubjectByID(subject_id);
	}
	
	public List<Subject> showSubjectByClass(int subject_class) {
		return subjectDAO.findSubjectByClass(subject_class);
	}
	
	public void updateSubject(Subject subject) {
		subjectDAO.updateSubject(subject);
	}

	public void deleteSubject(int subjectID) {
		subjectDAO.deleteSubject(subjectID);
	}

	public PageResult likeQueryBySubjectTitle(String subjectTitle, Page page) {
		page = PageUtil.createPage(page.getEveryPage(),
				subjectDAO.findLinkQueryCount(subjectTitle),page.getCurrentPage());//根据总记录数创建分页信息
		List<Subject> list = subjectDAO.likeQueryByTitle(subjectTitle, page);//通过分页信息模糊查询试题
		PageResult result = new PageResult(page,list);//封装分页信息和记录信息，返回给调用处
		return result;
	}
	*/
	public Subject findSubjectByClasses(int subject_class){
		return subjectDAO.findSubjectByClasses(subject_class);
	}
	public Subject showSubjectByID(int subject_id) {
		return subjectDAO.findSubjectByID(subject_id);
	}
	
	public List<SubjectInf> findAllSubject(){
		return subjectDAO.findAllSubject();
	}
	
	public List<Subject> showAllSubject() {
		return subjectDAO.showAllSubject();
	}
	public int numClasses(){
		return subjectDAO.numClasses();
	}
	public int numSubjectByClasses(int classes_id){
		return subjectDAO.numSubjectByClasses(classes_id);
	}
	
	/*
	public int accountResult(List<Integer> subjectIDs,
			List<String> studentAnswers) {
		int GeneralPoint = 0;//总分
		for(int i = 0; i < subjectIDs.size(); i++) {
			String rightAnswer = subjectDAO.
				findSubjectByID(subjectIDs.get(i)).getSubjectAnswer();//得到正确答案，通过试题ID
			if(rightAnswer.equals(studentAnswers.get(i))) {
				GeneralPoint += 5;//加5分
			}
		}
		return GeneralPoint;
	}
	*/
}
