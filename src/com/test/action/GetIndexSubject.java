package com.test.action;

import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.test.po.Subject;
import com.test.service.SubjectService;
import com.test.service.SubjectServiceImpl;
import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class GetIndexSubject extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	private SubjectService subjectService = new SubjectServiceImpl();
	@Override
	public String execute() throws Exception {
		Subject subject=subjectService.findSubjectByClasses(0);
		Map map = new HashMap();
		map.put("part1", subject);
		JSONObject json=JSONObject.fromObject(map);
		this.result=json.toString();
		System.out.println(this.result);
		//{"part1":{"subject_class":0,"subject_id":1,"subject_title":"大学生为毕业求职做准备理所当然"}}
		return SUCCESS;
	}

}
