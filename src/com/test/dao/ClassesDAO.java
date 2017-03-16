package com.test.dao;

import java.util.List;
import com.test.po.Classes;
import com.test.po.Subject;
import com.test.util.Page;

public interface ClassesDAO {

	//public void addClasses(Classes classes);
	public Classes showClassesByID(int classes_id);
	public Classes findClassesByTitle(String classes_title);
	
	//public void updateClasses(Classes classes);
	
	//public void deleteClasses(int classes_id);
}
