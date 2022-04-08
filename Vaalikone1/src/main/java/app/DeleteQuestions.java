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

//Delete nappia painettu
@WebServlet(
		name = "DeleteQuestions",
		urlPatterns = {"/deletequestions"}
)
//T�h�n database
public class DeleteQuestions extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
	// Delete nappia painettu viewiss�.jsp eli pyydetty doget metodia
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id"); // ID vastaanotto showcandidatelta
		ArrayList<Questions> list=null; // n�yt� lista deletoinnin j�lkeen, ehdokaslistan vastaanoton valmistelu
		if (dao.getConnection()) { // yhteydenotto
			list=dao.deleteQuestions(id); // dao poista ehdokas
		}
		request.setAttribute("questionslist", list); // pyynt� p�ivitetyst� listasta
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp"); // l�hetet��n p�ivitetty lista eteenp�in
		rd.forward(request, response);
	}

}
