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
import data.Candidates;

// Delete nappia painettu
/**
 * Date: 23.4.2022
 * This is Election Machine where admin can add questions.
 * @author owner group 20M Anna Westerback, Ansa Holttinen and Johanna Sieranoja TRTKM20A3
 * @version 1.0
 */
@WebServlet(
    name = "DeleteCandidates",
    urlPatterns = {"/deletecandidates"}
)
//T�h�n database
public class DeleteCandidates extends HttpServlet {
	private Dao dao;
	/**
	 * This is method to create connection to database
	 */
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
	// Delete nappia painettu viewiss�.jsp eli pyydetty doget metodia
	/**
	 * This is method to delete candidates from database
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id"); // ID vastaanotto showcandidatelta
		ArrayList<Candidates> list=null; // n�yt� lista deletoinnin j�lkeen, ehdokaslistan vastaanoton valmistelu
		if (dao.getConnection()) { // yhteydenotto
			list=dao.deleteCandidates(id); // dao poista ehdokas
		}
		request.setAttribute("candidateslist", list); // pyynt� p�ivitetyst� listasta
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidates.jsp"); // l�hetet��n p�ivitetty lista eteenp�in
		rd.forward(request, response);
	}
}