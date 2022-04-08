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
 * Servlet implementation class ShowQuestions
 */
@WebServlet("/ShowQuestions")// osoite johon websivu vastaa
public class ShowQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	// Alusta DAO-luokka joka hoitaa tietokantaoperaatiot, voi koodata toisin ettei tarvitse päivittää kaikkiin appeihin
	// Servletille ajetaan init-vaihe kaikissa apeissa, vasta sen jälkeen view/index.html
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
    
    // DO-GET index.html linkkiä "showquestions" painettu
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Questions> list=null; // tee arraylist, ei tiedä millainen olio palautetaan
		if (dao.getConnection()) { // dao ota yhteys tietokantaan
			list=dao.readAllQuestions(); // dao anna lista kaikista ehdokkaista, DAO palauttaa hakemansa tiedot listana serveletille eli controllerille, joka näkyy viewiin html
		}
		else {
			System.out.println("No connection to database");
		}
		// pyyntö, laita lista requestille
		request.setAttribute("questionslist", list); // request attribuutilla setattribute metodi. Request ottaa muita olioita sisäänsä, set attribuutilla laitetaan sinne uutta tietoa eli lista, joka löytyy questionslist nimellä
		// tiedon välittäminen
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp"); //tämä luo meille näkymän, jsp = view osan servletti, muut back-end
		rd.forward(request, response);
	}
}
