package com.test.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.test.po.Analyse;
import com.test.service.SubjectService;
import com.test.service.SubjectServiceImpl;

import net.sf.json.JSONObject;



@SuppressWarnings("serial")
public class SubmitExam extends ActionSupport implements SessionAware{
	private String part1;
	private String part2;
	private float score;
	private String result; 
	public String getPart1(){
		return this.part1;
	}
	public void setPart1(String part1){
		this.part1=part1;
	}
	
	public String getPart2(){
		return this.part2;
	}
	public void setPart2(String part2){
		this.part2=part2;
	}
	
	public void setScore(float score){
		this.score=score;
	}
	public float getScore(){
		return this.score;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	SubjectService subjectService=new SubjectServiceImpl();
	@Override
	public String execute() throws Exception {
		
		int numscore=0;//总分数，百分制
		
		JSONObject json = new JSONObject();
		JSONObject js = new JSONObject();
		
		JSONObject part1=JSONObject.fromObject(this.part1);
		float part1_numscore=(float)part1.getInt("score");//获取part1的分数
		//float part1_numscore=(float) 80.0;
		float part2_numscore=(float) 0.0;
		JSONObject part2=JSONObject.fromObject(this.part2);
		int numclasses=subjectService.numClasses()-1;//获取part2部分题目类型的总数
		for(int i=1;i<=numclasses;++i){
			JSONObject step=part2.getJSONObject("step"+i);
			List<Analyse> li=new ArrayList<Analyse>();
			
			//每一类别classes的题目数
			int numSubject=subjectService.numSubjectByClasses(i);
			
			for(int j=0;j<numSubject;++j){
				
				Analyse analy=new Analyse(); 
				
				int part2_score=step.getJSONArray("subjects").getJSONObject(j).getInt("score");//获取每一题的分数
				analy.setScore(part2_score);
				
				String subject_title=(String) step.getJSONArray("subjects").getJSONObject(j).get("subject_title");//获取每一题的题目
				analy.setSubject(subject_title);
				
				if(part2_score>=90){//90分以上分项评价总分加5分
					part2_numscore+=5;
					analy.setAnalysis("你的表现非常棒");
				}
				if(part2_score>=80 && part2_score<90){
					part2_numscore+=4;
			
					analy.setAnalysis("你的表现很棒");
				}
				if(part2_score>=70 && part2_score<80){
					part2_numscore+=3;
					
					analy.setAnalysis("你的表现要更进一步");
				}
				if(part2_score>=60 && part2_score<70){
					part2_numscore+=2;
					
					analy.setAnalysis("你的表现很一般");
				}
				if(part2_score<60){
					part2_numscore+=1;				
					analy.setAnalysis("你的表现需要加强");
				}
				li.add(analy);
				
			}
			js.put("step"+i, li);
		}
		numscore=(int) (part1_numscore*0.3+part2_numscore*100.0*0.7/125.0);//计算总分

		json.put("total_results", numscore);
		
		//分项总分评价
		if(part2_numscore>=100){
			json.put("part_advise", "准备充分，请放心参加求职活动");
		}
		else if(part2_numscore>=75){
			json.put("part_advise", "有所准备，记得在努力一些哟!");
		}
		else if(part2_numscore>=60){
			json.put("part_advise", "各方面还需要加强!");
		}
		else if(part2_numscore>=40){
			json.put("part_advise", "一定要提前做好求职准备!");
		}
		else{
			json.put("part_advise", "你好懒，什么都没有做!");
		}
		
		//分项和总体评价比较
		if (part1_numscore>part2_numscore){
			json.put("com_advise", "你对求职特别自信，但别盲目自信哟!");
		}
		if (part2_numscore>(part1_numscore+30)){
			json.put("com_advise", "你缺乏求职自信，一定要相信自己哟!");
		}
	
		json.put("special_result", js);
		//this.result=json.toString();
		System.out.println("###"+json);
		session.put("result",json);
		//System.out.println(this.result);
		return SUCCESS;
	}
	
	private Map<String, Object> session;
	@Override
	public void setSession( Map<String, Object> session) {
		this.session = session;
	}
}
