package com.test.service;

import java.util.List;

import com.test.po.Classes;
import com.test.util.Page;
import com.test.util.PageResult;


public interface ClassesService {
	
	//public boolean saveClasses(Classes subject);
	
	public Classes showClassesByID(int classes_id);
	
	// 更新类型信息
	//public void updateClasses(Classes classes);
	
	// 删除类型信息
	//public void deleteClasses(int classes_id);
	
}
