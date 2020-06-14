package com.wk.service.impl;

import com.wk.dao.IndexDao;
import com.wk.service.IndexService;
import com.wk.ucc.IndexUCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("service")
public class IndexServiceImpl implements IndexService {
	@Autowired
	private IndexDao dao;
	@Autowired
	private IndexUCC indexUcc;
	//无参构造方法
	public IndexServiceImpl(){
		System.out.println("service constructor");
	}
	//有参构造方法
	@Autowired
	public IndexServiceImpl(IndexDao indexDao){
		this.dao =indexDao;
		System.out.println("service constructor dao");
	}
	//初始化方法
	@PostConstruct//使用初始化方法的注解
	public void init(){
//		System.out.println("service init");
	}
	@Override
	public void query() {
		System.out.println("dao:***"+dao.getClass().getSimpleName());
		dao.query();
//		System.out.println("service");

//		indexUcc.query();
	}

	public void setDao(IndexDao dao) {
		this.dao = dao;
	}

	public void setIndexUcc(IndexUCC indexUcc) {
		this.indexUcc = indexUcc;
	}
}
