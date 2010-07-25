
package com.eknv.dao;

import com.eknv.model.JavaTest;

import java.util.List;

public interface JavaTestDao
{
	public void insert(JavaTest javaTest);
	public JavaTest findById(int id);
	public List findAll();
}
