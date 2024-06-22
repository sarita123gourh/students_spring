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

public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter p=response.getWriter();
		//read the request 
		
		int id=Integer.parseInt(request.getParameter("u1"));
		p.println(id);
		//process the request
		
		Configuration config=new Configuration().configure();
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		
		//Student s1=session.get(Student.class,id);
		
		Transaction tr=session.beginTransaction();
		Student student=session.get(Student.class,id);
		
		//provide the response
		p.println(student);
		
		if(student!=null)
		{
		Student f=new Student();
		f.setName("pooja");
		f.setBatch("java");
		f.setMarks(90);
		f.setJoiningDate("19/10/2003");
		session.update(f);
		}
		
		p.println("data updated");
		tr.commit();
		session.close();
		
		p.println("data updated");
	}

}
