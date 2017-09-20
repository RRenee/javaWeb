package com.test.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate.HibernateSessionFactory;
import com.test.po.Classes;
import com.test.po.Subject;
import com.test.util.Page;

public class ClassesDAOImpl implements ClassesDAO{
	/*
	public void addClasses(Classes classes){
		Session session = HibernateSessionFactory.getSession();
		Transaction  transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(classes);
			transaction.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}
	*/
	public Classes showClassesByID(int classes_id){
		Session session = HibernateSessionFactory.getSession();
		Classes classes = (Classes) session.get(Classes.class, classes_id);
		HibernateSessionFactory.closeSession();		//关闭Session对象
		return classes;
	}
	
	public Classes findClassesByTitle(String classes_title){
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Query query = session.createQuery("from Classes where Classes.classes_title = ?");
		query.setString(0, classes_title);
		List list = query.list();					//查询结果保存到list中
		HibernateSessionFactory.closeSession();		//关闭Session对象
		if(list.size() == 0) {
			return null;							//返回null
		}else {
			return (Classes) list.get(0);			//返回第一个试题
		}
	}
	/*
	public void updateClasses(Classes classes){
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.update(classes);//更新试题信息
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
	
	public void deleteClasses(int classes_id){
		Session session = HibernateSessionFactory.getSession();//获得Session对象
		Classes classes = (Classes) session.get(Classes.class, classes_id);
		Transaction  transaction = null;//声明一个事务对象
		try{
			transaction = session.beginTransaction();//开启事务
			session.delete(classes);
			transaction.commit();//提交事务
		}catch(Exception ex) {
			ex.printStackTrace();
			transaction.rollback();//事务回滚
		}
		HibernateSessionFactory.closeSession();//关闭Session对象
	}
	*/
}
