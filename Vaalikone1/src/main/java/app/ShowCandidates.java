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

// Model DAO View index.html Controller servletti

/**
 * Servlet implementation class ShowCandidates
 */

// javadoc otsikko class ulkopuolelle - hiiren oikea > Source > Generate element comment
/**
 * Date: 23.4.2022
 * This is Election Machine program that shows candidates for administrator.
 * @author owner group 20M Anna Westerback, Ansa Holttinen and Johanna Sieranoja TRTKM20A3
 * @version 1.0
 *
 */
@WebServlet("/showcandidates") // osoite johon view/index.html vastaa
public class ShowCandidates extends HttpServlet {
	
	// javadoc class ulkopuolelle kuvaus atribuuteista klikkaa attribuutin oikealla puolella, kuvaus attribuuteista
	/**
	 * serialVersionUID for universal version identifier for a serializable class
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dao class for methods
	 */
	private Dao dao=null;
	
	// Alusta DAO-luokka joka hoitaa tietokantaoperaatiot, voi koodata toisin ettei tarvitse p�ivitt�� kaikkiin appeihin
	// Servletille ajetaan init-vaihe kaikissa apeissa, vasta sen j�lkeen view/index.html
	// javadoc metodin sis�lle
	/**
	 * Log in database
	 */
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
       
    /**
     * This method shows all candidates
     * @see HttpServlet#HttpServlet()
     */
	// LUOKKA
    public ShowCandidates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * This method creates a list, get connection in database and show candidates
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) this get-method find candidates when link is pressed
	 */
    
    // DO-GET index.html linkki� "showcandidates" painettu, GET hakee tiedon, ei POST
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
