package com.db.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.db.Entity.Student;

public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter p=response.getWriter();
		//read the request 
		
		int id=Integer.parseInt(request.getParameter("d1"));
		p.println(id);
		//process the request
		
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		//Student s1=session.get(Student.class,id);
		
		Transaction tr=session.beginTransaction();
		Student student=session.get(Student.class,id);
		
		//provide the response
		if(student!=null)
		{
			session.remove(student);
			p.println("data removed");
		}
		
		tr.commit();
		session.close();
	}

}
