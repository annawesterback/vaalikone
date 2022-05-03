package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.UserQuestions;

@Path("/vaalikoneservice")
public class VaalikoneService {
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
// lue kaikki rivit taulusta kysymykset
	@GET
	@Path("/all") // http://localhost:8080/rest/vaalikoneservice/all
	@Produces(MediaType.APPLICATION_JSON)
	public void readAllUserQuestions() {
		//Create an EntityManagerFactory with the settings from persistence.xml file
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone"); // EntityManagerFactory luo yhteys tietokantaan, tämä sama persistencessä, eli jpa käyttää tätä
		//And then EntityManager, which can manage the entities.
		EntityManager em=emf.createEntityManager();
		
		// Read all the rows from table prey. Here the Prey must start with capital, 
		// because class's name starts. This returns a List of Prey objects.
		List<UserQuestions> list=em.createQuery("select k from UserQuestions k").getResultList(); //Luokan nimi UserQuestions, siellä kerrottu että tämä luokka tarkoittaa tiekannassa @table kysymykset
		// return list;
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/usershowquestions.jsp");
		request.setAttribute("questionslist", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// lue kaikki rivit taulusta kysymykset
		@GET
		@Path("/allanswers") // http://localhost:8080/rest/vaalikoneservice/all
		@Produces(MediaType.APPLICATION_JSON)
		public void readAllUserAnswers() {
			//Create an EntityManagerFactory with the settings from persistence.xml file
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone"); // EntityManagerFactory luo yhteys tietokantaan, tämä sama persistencessä, eli jpa käyttää tätä
			//And then EntityManager, which can manage the entities.
			EntityManager em=emf.createEntityManager();
			
			// Read all the rows from table prey. Here the Prey must start with capital, 
			// because class's name starts. This returns a List of Prey objects.
			List<UserQuestions> list=em.createQuery("select k from Answers k").getResultList(); //Luokan nimi UserQuestions, siellä kerrottu että tämä luokka tarkoittaa tiekannassa @table kysymykset
			// return list;
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/usershowanswers.jsp");
			request.setAttribute("answerslist", list);
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
}