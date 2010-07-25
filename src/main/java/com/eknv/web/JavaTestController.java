package com.eknv.web;

import com.eknv.dao.impl.JdbcJavaTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

public class JavaTestController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
    private JdbcJavaTestDao javaTestDao = null;

/*    @Autowired*/
    public void setJavaTestDao(JdbcJavaTestDao javaTestDao) {
        this.javaTestDao = javaTestDao;
    }

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Returning javatest view");
		System.out.println("stdout - Returning javatest view");
        /*System.out.println(javaTestDao.test());*/
		return new ModelAndView("javatest.jsp", "javaTestList", javaTestDao.findAll());
	}
}
