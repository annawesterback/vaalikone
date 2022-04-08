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
 * Servlet implementation class ShowQuestions
 */
@WebServlet("/ShowQuestions")// osoite johon view/index.html vastaa
public class ShowQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	// Alusta DAO-luokka joka hoitaa tietokantaoperaatiot, voi koodata toisin ettei tarvitse p�ivitt�� kaikkiin appeihin
	// Servletille ajetaan init-vaihe kaikissa apeissa, vasta sen j�lkeen view/index.html
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowQuestions () {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // DO-GET index.html linkki� "showcandidates" painettu
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Candidates> list=null; // tee arraylist, ei tied� millainen olio palautetaan
		if (dao.getConnection()) { // dao ota yhteys tietokantaan
			list=dao.readAllCandidates(); // dao anna lista kaikista ehdokkaista, DAO palauttaa hakemansa tiedot listana serveletille eli controllerille, joka n�kyy viewiin html
		}
		else {
			System.out.println("No connection to database");
		}
		// pyynt�, laita lista requestille
		request.setAttribute("candidateslist", list); // request attribuutilla setattribute metodi. Request ottaa muita olioita sis��ns�, set attribuutilla laitetaan sinne uutta tietoa eli lista, joka l�ytyy candidateslist nimell�
		// tiedon v�litt�minen
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showcandidates.jsp"); //t�m� luo meille n�kym�n, jsp = view osan servletti, muut back-end
		rd.forward(request, response);
	}
}
