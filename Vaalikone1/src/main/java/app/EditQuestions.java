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
 * Servlet implementation class EditQuestions
 */
@WebServlet(
	    name = "EditQuestions",
	    urlPatterns = {"/editquestions"}
	)
public class EditQuestions extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("index.html"); 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("kysymys_id");
		String kysymys=request.getParameter("kysymys");
		
		Questions f=new Questions(id, kysymys);
		System.out.println("update: "+ f.toString());
		
		ArrayList<Questions> list=null;
		if (dao.getConnection()) {
			list=dao.updateQuestions(f);
		}
		
		request.setAttribute("questionslist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp");
		response.sendRedirect("/ShowQuestions");
	}

}
