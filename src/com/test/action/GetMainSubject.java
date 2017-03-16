package com.test.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import com.test.po.Subject;
import com.test.po.Classes;
import com.test.service.SubjectService;
import com.test.service.SubjectServiceImpl;
import com.test.service.ClassesService;
import com.test.service.ClassesServiceImpl;

@SuppressWarnings("serial")
public class GetMainSubject extends ActionSupport{
	private SubjectService subjectService = new SubjectServiceImpl();
	private ClassesService classesService= new ClassesServiceImpl();
	private String allsubject;
	
	public String getAllsubject() {
		return allsubject;
	}
	public void setAllsubject(String allsubject) {
		this.allsubject = allsubject;
	}
	@Override
	public String execute() throws Exception {	
		JSONObject json = new JSONObject();
		JSONObject js = new JSONObject();
		List<Subject> subject =subjectService.showAllSubject(); 
		int numclass=subjectService.numClasses();
		for(int i=1;i<numclass;++i){
			Classes classes=classesService.showClassesByID(i);//��ȡÿ�����͵ı���
			//System.out.println(classes.getClasses_title());
			List<Subject> sub=new ArrayList<Subject>();
			JSONObject jn = new JSONObject();
			jn.put("sub_class", classes.getClasses_title());
			for(int j=0;j<subject.size();++j){
				if (subject.get(j).getSubject_class()==i){
					sub.add(subject.get(j));
				}
			}
			jn.put("subjects", sub);
			js.put("step"+i, jn);
			//json.put(key, value);
		}
		json.put("part2", js);
		this.allsubject=json.toString();
		//System.out.println(this.allsubject);
		return SUCCESS;
	}
}