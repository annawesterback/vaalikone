package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


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

import data.Answers;
import data.UserQuestions;
import model.Kysymykset;
import model.Vastaukset;

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
		List<Kysymykset> list=em.createQuery("select k from Kysymykset k").getResultList(); //Luokan nimi UserQuestions, siellä kerrottu että tämä luokka tarkoittaa tiekannassa @table kysymykset
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
	
	
	// lue kaikki rivit taulusta vastaukset
		@GET
		@Path("/allanswers") // http://localhost:8080/rest/vaalikoneservice/allanswers
		@Produces(MediaType.APPLICATION_JSON)
		public void readAllUserAnswers() {
			//Create an EntityManagerFactory with the settings from persistence.xml file
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone"); // EntityManagerFactory luo yhteys tietokantaan, tämä sama persistencessä, eli jpa käyttää tätä
			//And then EntityManager, which can manage the entities.
			EntityManager em=emf.createEntityManager();
			
			// Read all the rows from table prey. Here the Prey must start with capital, 
			// because class's name starts. This returns a List of Prey objects.
			List<Vastaukset> list=em.createQuery("select k from Vastaukset k").getResultList(); //Luokan nimi UserQuestions, siellä kerrottu että tämä luokka tarkoittaa tiekannassa @table kysymykset
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

//		
//		package services;
//
//		import java.io.IOException;
//		import java.util.List;
//
//
//		import javax.persistence.EntityManager;
//		import javax.persistence.EntityManagerFactory;
//		import javax.persistence.Persistence;
//		import javax.servlet.RequestDispatcher;
//		import javax.servlet.ServletException;
//		import javax.servlet.http.HttpServletRequest;
//		import javax.servlet.http.HttpServletResponse;
//		import javax.ws.rs.Consumes;
//		import javax.ws.rs.DELETE;
//		import javax.ws.rs.POST;
//		import javax.ws.rs.PUT;
//		import javax.ws.rs.GET;
//		import javax.ws.rs.Path;
//		import javax.ws.rs.PathParam;
//		import javax.ws.rs.Produces;
//		import javax.ws.rs.core.Context;
//		import javax.ws.rs.core.MediaType;
//
//		import data.Answers;
//
//		@Path("/vaalikoneservice")
//		public class VaalikoneService {
//			
//			EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
//			
//			@GET
//			@Path("/readanswer")
//			@Produces(MediaType.APPLICATION_JSON)
//			@Consumes(MediaType.APPLICATION_JSON)
//			public List<Answers> readAnswer() {
//				EntityManager em=emf.createEntityManager();
//				em.getTransaction().begin();
//				List<Answers> list=em.createQuery("select a from Answers a").getResultList();		
//				em.getTransaction().commit();
//				return list;
//			}	
//			
//			@GET
//			@Path("/readallanswer")
//			@Produces(MediaType.APPLICATION_JSON)
//			@Consumes(MediaType.APPLICATION_JSON)
//			public void readAllAnswer(@Context HttpServletRequest request, @Context HttpServletResponse response) {
//				EntityManager em=emf.createEntityManager();
//				em.getTransaction().begin();
//				List<Answers> list=em.createQuery("select a from Answers a").getResultList();		
//				em.getTransaction().commit();
//				RequestDispatcher rd=request.getRequestDispatcher("/jsp/readallanswers.jsp");
//				request.setAttribute("answerslist", list);
//				try {
//					rd.forward(request, response);
//				} catch (ServletException | IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}	
//			@POST
//			@Path("/addanswer")
//			@Produces(MediaType.APPLICATION_JSON)
//			@Consumes(MediaType.APPLICATION_JSON)
//			public List<Answers> addAnswer(Answers answer) {
//				EntityManager em=emf.createEntityManager();
//				em.getTransaction().begin();
//				em.persist(answer);//The actual insertion line
//				em.getTransaction().commit();
//				//Calling the method readFish() of this service
//				List<Answers> list=readAnswer();		
//				return list;
//			}	
//			@PUT
//			@Path("/updateanswer")
//			@Produces(MediaType.APPLICATION_JSON)
//			@Consumes(MediaType.APPLICATION_JSON)
//			public List<Answers> updateAnswer(Answers answer) {
//				EntityManager em=emf.createEntityManager();
//				em.getTransaction().begin();
//				Answers a=em.find(Answers.class, answer.getEhdokas_id()); //select * from fish where id=fish.getId()
//				if (a!=null) {
//					em.merge(answer);//The actual update line
//				}
//				em.getTransaction().commit();
//				//Calling the method readFish() of this service
//				List<Answers> list=readAnswer();		
//				return list;
//			}	
//			@DELETE
//			@Path("/deleteanswer/{ehdokas_id}")
//			@Produces(MediaType.APPLICATION_JSON)
//			@Consumes(MediaType.APPLICATION_JSON)
//			public List<Answers> deleteAnswer(@PathParam("ehdokas_id") int ehdokas_id) {
//				EntityManager em=emf.createEntityManager();
//				em.getTransaction().begin();
//				Answers a=em.find(Answers.class, ehdokas_id);
//				if (a!=null) {
//					em.remove(a);//The actual delete line
//				}
//				em.getTransaction().commit();
//				//Calling the method readFish() of this service
//				List<Answers> list=readAnswer();		
//				return list;
//			}	
//			@GET
//			@Path("/deleteanswer/{ehdokas_id}")
//			@Produces(MediaType.APPLICATION_JSON)
//			@Consumes(MediaType.APPLICATION_JSON)
//			public void deleteFishByGet(@PathParam("ehdokas_id") int ehdokas_id, 
//					@Context HttpServletRequest request,
//					@Context HttpServletResponse response
//					) {
//				EntityManager em=emf.createEntityManager();
//				em.getTransaction().begin();
//				Answers a=em.find(Answers.class, ehdokas_id);
//				if (a!=null) {
//					em.remove(a);//The actual delete line
//				}
//				em.getTransaction().commit();
//				//Calling the method readFish() of this service
//				List<Answers> list=readAnswer();		
//				
//				RequestDispatcher rd=request.getRequestDispatcher("/jsp/answersform.jsp");
//				request.setAttribute("answerslist", list);
//				try {
//					rd.forward(request, response);
//				} catch (ServletException | IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}	
//			@GET
//			@Path("/readtoupdateanswer/{ehdokas_id}")
//			@Produces(MediaType.APPLICATION_JSON)
//			@Consumes(MediaType.APPLICATION_JSON)
//			public Answers readToUpdateAnswer(@PathParam("ehdokas_id") int ehdokas_id) {
//				EntityManager em=emf.createEntityManager();
//				em.getTransaction().begin();
//				Answers a=em.find(Answers.class, ehdokas_id);
//				em.getTransaction().commit();
//				return a;
//			}	
//		}
//	
//		
	