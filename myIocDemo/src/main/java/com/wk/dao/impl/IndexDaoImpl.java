package com.wk.dao.impl;

import com.wk.dao.IndexDao;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class IndexDaoImpl implements IndexDao {
	@Override
	public void query() {
		System.out.println("dao-query()");
	}
}
