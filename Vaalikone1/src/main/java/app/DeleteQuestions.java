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
/**
 * Date: 23.4.2022
 * This is Election Machine where admin can delete questions.
 * @author owner group 20M Anna Westerback, Ansa Holttinen and Johanna Sieranoja TRTKM20A3
 * @version 1.0
 */
@WebServlet(
		name = "DeleteQuestions",
		urlPatterns = {"/deletequestions"}
)
//Tähän database
public class DeleteQuestions extends HttpServlet {
	private Dao dao;
	/**
	 * This is method to create connection to database
	 */
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
	// Delete nappia painettu viewissä.jsp eli pyydetty doget metodia
	/**
	 * This is method to delete questions and show updated list of questions
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id"); // ID vastaanotto showcandidatelta
		ArrayList<Questions> list=null; // näytä lista deletoinnin jälkeen, ehdokaslistan vastaanoton valmistelu
		if (dao.getConnection()) { // yhteydenotto
			list=dao.deleteQuestions(id); // dao poista ehdokas
		}
		request.setAttribute("questionslist", list); // pyyntö päivitetystä listasta
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp"); // lähetetään päivitetty lista eteenpäin
//		rd.forward(request, response);
		response.sendRedirect("/ShowQuestions");
	}

}
