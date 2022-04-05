// Tässä kopsattu fisujen update

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

@WebServlet(
    name = "EditCandidates",
    urlPatterns = {"/editcandidates"}
)

// Tähän myös oikea database
public class EditCandidates extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("index.html"); // TÄSSÄ täytyy olla sivu jossa editoidaan tietoja
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("ehdokas_id");
		String sukunimi=request.getParameter("sukunimi");
		String etunimi=request.getParameter("etunimi");
		String puolue=request.getParameter("puolue");
		
		Candidates f=new Candidates(id, sukunimi, etunimi, puolue);
		
		ArrayList<Candidates> list=null;
		if (dao.getConnection()) {
			list=dao.updateCandidates(f);
		}
		
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidates.jsp");
		rd.forward(request, response);
	}
}