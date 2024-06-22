package com.db.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.db.Entity.Student;


public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter p=response.getWriter();
		//read the request 
		
		int id=Integer.parseInt(request.getParameter("i1"));
		String s1=request.getParameter("i2");
		String s2=request.getParameter("i3");
		int marks=Integer.parseInt(request.getParameter("i4"));
		String s3=request.getParameter("i5");
		
		p.println(id);
		//process the request
		
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		//Student s1=session.get(Student.class,id);
		
		Transaction tr=session.beginTransaction();
		Student s = new Student(id, s1,s2, marks,s3);
		session.save(s);
		
		
		//provide the response
		
		tr.commit();
		session.close();
		p.println("data inseted");
		response.sendRedirect("ShowAll");
		
	}

}
