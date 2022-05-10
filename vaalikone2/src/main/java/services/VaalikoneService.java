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
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.Ehdokkaat;
import model.Kysymykset;
import model.Vastaukset;

@Path("/vaalikoneservice")
public class VaalikoneService {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone"); // EntityManagerFactory luo yhteys tietokantaan, tämä sama persistencessä, eli jpa käyttää tätä
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
// lue kaikki rivit taulusta kysymykset
	@GET
	@Path("/all") // http://localhost:8080/rest/vaalikoneservice/all
	@Produces(MediaType.APPLICATION_JSON)
	public void readAllUserQuestions() {
		//Create an EntityManagerFactory with the settings from persistence.xml file
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
	
	@GET
	@Path("/readanswer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Vastaukset> readAnswers() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<Vastaukset> list=em.createQuery("select k from Vastaukset k").getResultList();		
		em.getTransaction().commit();
		return list;
	}
	
	
	// lue kaikki rivit taulusta vastaukset
		@GET
		@Path("/allanswers") // http://localhost:8080/rest/vaalikoneservice/allanswers
		@Produces(MediaType.APPLICATION_JSON)
		public void readAllUserAnswers() {
			//Create an EntityManagerFactory with the settings from persistence.xml file
		
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
			@POST
			@Path("/addanswer")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes("application/x-www-form-urlencoded")
			public void addAnswer(@FormParam("eid") int eid, @FormParam("kid") int kid, @FormParam("vastaus") int vastaus, @FormParam("kommentti") String kommentti) {
				System.out.println(eid + " " + kid + " " + vastaus + " " + kommentti);
				Ehdokkaat e = new Ehdokkaat();
				e.setEhdokasId(eid);
				Kysymykset k = new Kysymykset();
				k.setKysymysId(kid);
				Vastaukset v = new Vastaukset();
				v.setVastaus(vastaus);
				v.setKommentti(kommentti);
				v.setEhdokkaat(e);
				v.setKysymykset(k);
				
				
				EntityManager em=emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(v);//The actual insertion line
				em.getTransaction().commit();
				readAllUserAnswers();
			}	


			@POST
			@Path("/updateanswer")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes("application/x-www-form-urlencoded")
			public void updateAnswer(@FormParam("vastaus_id") int vid,@FormParam("ehdokas_id") int eid, @FormParam("kysymys_id") int kid, @FormParam("vastaus") int vastaus, @FormParam("kommentti") String kommentti) {
				System.out.println(eid + " " + kid + " " + vastaus + " " + kommentti);
				Ehdokkaat e = new Ehdokkaat();
				e.setEhdokasId(eid);
				Kysymykset k = new Kysymykset();
				k.setKysymysId(kid);
				Vastaukset v = new Vastaukset();
				v.setVastaus(vastaus);
				v.setKommentti(kommentti);
				v.setEhdokkaat(e);
				v.setKysymykset(k);
				v.setId(vid);
				
				EntityManager em=emf.createEntityManager();
				em.getTransaction().begin();
				Vastaukset vanha=em.find(Vastaukset.class, v.getId()); //select * from fish where id=fish.getId()
				if (vanha!=null) {
					em.merge(v);//The actual update line
					em.getTransaction().commit();
				}			
				readAllUserAnswers();


			}	
//			@DELETE
//			@Path("/deleteanswer/{id}")
//			@Produces(MediaType.APPLICATION_JSON)
//			@Consumes(MediaType.APPLICATION_JSON)
//			public List<Vastaukset> deleteAnswer(@PathParam("id") int id) {
//				EntityManager em=emf.createEntityManager();
//				em.getTransaction().begin();
//				Vastaukset v=em.find(Vastaukset.class, id);
//				if (v!=null) {
//					em.remove(v);//The actual delete line
//				}
//				em.getTransaction().commit();
//				//Calling the method readFish() of this service
//				List<Vastaukset> list=readAnswers();		
//				return list;
//			}	
			@GET
			@Path("/deleteanswer/{id}")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public void deleteAnswerByGet(@PathParam("id") int id, 
					@Context HttpServletRequest request,
					@Context HttpServletResponse response
					) {
				EntityManager em=emf.createEntityManager();
				em.getTransaction().begin();
				Vastaukset v=em.find(Vastaukset.class, id);
				if (v!=null) {
					em.remove(v);//The actual delete line
				}
				em.getTransaction().commit();
				//Calling the method readFish() of this service
				List<Vastaukset> list=readAnswers();		
				
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/usershowanswers.jsp");
				request.setAttribute("answerslist", list);
				try {
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
			@GET
			@Path("/readtoupdateanswer/{id}")
			@Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public void readToUpdateAnswer(@PathParam("id") int id) {
				EntityManager em=emf.createEntityManager();
				em.getTransaction().begin();
				Vastaukset v=em.find(Vastaukset.class, id);
				em.getTransaction().commit();
				
				RequestDispatcher rd=request.getRequestDispatcher("/jsp/answersuptodateform.jsp");
				request.setAttribute("answer", v);
				try {
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	
		
