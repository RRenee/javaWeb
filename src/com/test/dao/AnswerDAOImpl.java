package com.test.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate.HibernateSessionFactory;
import com.test.po.Answer;
import com.test.po.Subject;

public class AnswerDAOImpl implements AnswerDAO{
	public Answer findByAnswerID(int answer_id) {
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Answer answer = (Answer) session.get(Answer.class, answer_id);
		HibernateSessionFactory.closeSession();//关闭Session对象
		return answer;
	}

}
