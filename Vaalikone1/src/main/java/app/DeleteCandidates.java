//Tämä kopsattu fisuista

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
@WebServlet(
    name = "DeleteCandidates",
    urlPatterns = {"/deletecandidates"}
)
//Tähän database
public class DeleteCandidates extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
	// Delete nappia painettu viewissä.jsp eli pyydetty doget metodia
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id"); // ID vastaanotto showcandidatelta
		ArrayList<Candidates> list=null; // näytä lista deletoinnin jälkeen, ehdokaslistan vastaanoton valmistelu
		if (dao.getConnection()) { // yhteydenotto
			list=dao.deleteCandidates(id); // dao poista ehdokas
		}
		request.setAttribute("candidateslist", list); // pyyntö päivitetystä listasta
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidates.jsp"); // lähetetään päivitetty lista eteenpäin
		rd.forward(request, response);
	}
}