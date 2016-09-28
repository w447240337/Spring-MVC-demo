package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.EntityDao;
import com.mvc.entity.Student;

@Service
public class StudentService {
	@Autowired
	private EntityDao entityDao;
	
	@Transactional
	public List<Object> getStudentList(){
		StringBuffer sff = new StringBuffer();
		sff.append("select a from ").append(Student.class.getSimpleName()).append(" a ");
		List<Object> list = entityDao.createQuery(sff.toString());
		return list;
	}
	
	public List<Object> getStudentInfo(Student st){
		StringBuffer sff = new StringBuffer();
		sff.append("from ").append(Student.class.getName()).append(" where id= ").append(st.getId());
		List<Object> info = entityDao.createQuery(sff.toString());
		return info;
	}
	
	public void save(Student st){
		entityDao.save(st);
	}
	
	public void update(Student st){
		entityDao.update(st);
	}
	
	public void delete(Object obj){
		entityDao.delete(obj);
	}
}
