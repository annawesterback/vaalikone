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

/**
 * Date: 23.4.2022
 * This is Election Machine program where admin can edit candidates.
 * @author owner group 20M Anna Westerback, Ansa Holttinen and Johanna Sieranoja TRTKM20A3
 * @version 1.0
 */
@WebServlet(
    name = "EditCandidates",
    urlPatterns = {"/editcandidates"}
)
// Tähän myös oikea database
public class EditCandidates extends HttpServlet {
	private Dao dao;
	/**
	 * This method creates connection to database
	 */
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
	/**
	 * This method send response to index.html
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("index.html"); 
	}
	/**
	 * This is method to edit candidates
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("ehdokas_id");
		String sukunimi=request.getParameter("sukunimi");
		String etunimi=request.getParameter("etunimi");
		String ika=request.getParameter("ika");
		String kunta=request.getParameter("kotipaikkakunta");
		String puolue=request.getParameter("puolue");
		String ammatti=request.getParameter("ammatti");
		String miksi=request.getParameter("miksi_eduskuntaan");
		String mita=request.getParameter("mita_asioita_haluat_edistaa");

		
		Candidates f=new Candidates(id, sukunimi, etunimi, ika, kunta, puolue, ammatti, miksi, mita);
		System.out.println("update: "+ f.toString());
		
		ArrayList<Candidates> list=null;
		if (dao.getConnection()) {
			list=dao.updateCandidates(f);
		}
		
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidates.jsp");
//		rd.forward(request, response);
		response.sendRedirect("/showcandidates");
		
	}
}