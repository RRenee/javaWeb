package com.test.service;
import java.util.List;

import com.test.dao.ClassesDAO;
import com.test.dao.ClassesDAOImpl;
import com.test.dao.SubjectDAO;
import com.test.dao.SubjectDAOImpl;
import com.test.po.Classes;
import com.test.po.Subject;
import com.test.util.Page;
import com.test.util.PageResult;
import com.test.util.PageUtil;

public class ClassesServiceImpl implements ClassesService{
	
	private ClassesDAO classesDAO =  new ClassesDAOImpl();
	/*
	public boolean saveClasses(Classes classes) {
		String classes_title = classes.getClasses_title();
		if(classesDAO.findClassesByTitle(classes_title) == null){ //如果该试题标题不存在，允许添加
			classesDAO.addClasses(classes);
			return true;
		}else {
			return false;
		}
	}
	*/
	public Classes showClassesByID(int classes_id){
		return classesDAO.showClassesByID(classes_id);
	}
	/*
	// 更新类型信息
	public void updateClasses(Classes classes){
		classesDAO.updateClasses(classes);
		
	}
	
	// 删除类型信息
	public void deleteClasses(int classes_id){
		classesDAO.deleteClasses(classes_id);
	}
	*/
}
