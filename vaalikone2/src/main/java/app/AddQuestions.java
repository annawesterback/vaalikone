package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Questions;

/**
 * Servlet implementation class AddQuestions
 */
/**
 * Date: 23.4.2022
 * This is Election Machine prgram where admin can add questions.
 * @author owner group 20M Anna Westerback, Ansa Holttinen and Johanna Sieranoja TRTKM20A3
 * @version 1.0
 */
@WebServlet(
		name = "AddQuestions",
		urlPatterns = {"/addquestions"})
public class AddQuestions extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
	/**
	 * This is doGet method to show questions in website
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("jsp/addquestions.jsp"); 
		// response.sendRedirect("index.html"); 
	}
	/**
	 * This is doPost method to add questions to database
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("kysymys_id");
		String kysymys=request.getParameter("kysymys");
		
		Questions f=new Questions(id, kysymys);
		System.out.println("insert: "+ f.toString());
		
		ArrayList<Questions> list=null;
		if (dao.getConnection()) {
			list=dao.addQuestions(f);
		}
		
		request.setAttribute("questionslist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp");
//		rd.forward(request, response);
		response.sendRedirect("/ShowQuestions");
	}
}

