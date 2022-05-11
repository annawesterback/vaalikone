package app;

import java.io.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import model.Vastaukset;

@WebServlet(urlPatterns = {"/addanswer", "/deleteanswer","/updateanswer","/readanswer","/readtoupdateanswer"})
public class HandleAnswers extends HttpServlet {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
	  String action = request.getServletPath();
	  List<Vastaukset> list=null; 
	  switch (action) {
//	  case "/addanswer":
//		  list=addanswer(request);break;
	  case "/deleteanswer":
		  String id=request.getParameter("id");
		  list=deleteanswer(request);break;
//	  case "/updateanswer":
//		  list=updateanswer(request);break;
//	  case "/readanswer":
//		  list=readanswer(request);break;

	  }
//	  request.setAttribute("answerslist", list); 
//	  RequestDispatcher rd=request.getRequestDispatcher("./jsp/answerform.jsp"); //
//	  rd.forward(request, response);
  }


//	
//	private List<Vastaukset> readanswer(HttpServletRequest request) {
//		String id=request.getParameter("id");
//		String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/readanswer";
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Vastaukset>> genericList = new GenericType<List<Vastaukset>>() {};
//		
//		List<Vastaukset> returnedList=b.get(genericList);
//		return returnedList;
//	}
//	
//	private List<Vastaukset> updateanswer(HttpServletRequest request) {
//		//A Fish object to send to our web-service 
//		Vastaukset v=new Vastaukset(request.getParameter("id"), request.getParameter("vastaus"), request.getParameter("kommentti"));
//		System.out.println(v);
//		String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/updateanswer";
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Here we create an Entity of a Fish object as JSON string format
//		Entity<Vastaukset> e=Entity.entity(v,MediaType.APPLICATION_JSON);
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Vastaukset>> genericList = new GenericType<List<Vastaukset>>() {};
//		
//		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<Vastaukset> returnedList=b.put(e, genericList);
//		return returnedList;
//	}
	
	private List<Vastaukset> deleteanswer(HttpServletRequest request) {
		String id=request.getParameter("id");
		String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/deleteanswer/"+id;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Vastaukset>> genericList = new GenericType<List<Vastaukset>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Vastaukset> returnedList=b.delete(genericList);
		return returnedList;
	}
}