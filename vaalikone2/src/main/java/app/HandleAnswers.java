//package app;
//
//import java.io.*;
//import java.util.*;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.Invocation.Builder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.MediaType;
//
//import data.Answers;
//
//@WebServlet(urlPatterns = {"/addanswer", "/deleteanswer","/updateanswer","/readanswer","/readtoupdateanswer"})
//public class HandleAnswers extends HttpServlet {
//
//	  /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
//	      throws IOException, ServletException {
//		  doGet(request, response);
//	  }
//	  
//	  @Override
//	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
//	      throws IOException, ServletException {
//	  String action = request.getServletPath();
//	  List<Answers> list=null;
//	  switch (action) {
//	  case "/addanswer":
//		  list=addanswer(request);break;
//	  case "/deleteanswer":
//		  String id=request.getParameter("ehdokas_id");
//		  list=deleteanswer(request);break;
//	  case "/updateanswer":
//		  list=updateanswer(request);break;
//	  case "/readanswer":
//		  list=readanswer(request);break;
//	  case "/readtoupdateanswer":
//		  Answers a=readtoupdateanswer(request);
//		  request.setAttribute("Answers", a); // 
//		  RequestDispatcher rd=request.getRequestDispatcher("./jsp/answerstoupdateform.jsp"); //
//		  rd.forward(request, response);
//		  return;
//	  }
//	  request.setAttribute("answerslist", list); 
//	  RequestDispatcher rd=request.getRequestDispatcher("./jsp/answerform.jsp"); //
//	  rd.forward(request, response);
//  }
//
//	private Answers readtoupdateanswer(HttpServletRequest request) {
//		String ehdokas_id=request.getParameter("ehdokas_id"); //
//		String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/readtoupdateanswer/"+ehdokas_id;
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		Answers answers=b.get(Answers.class);
//		return answers;
//	}
//
//	private List<Answers> addanswer(HttpServletRequest request) {
//		//A Fish object to send to our web-service 
//		Answers a=new Answers(request.getParameter("kysymys_id"), request.getParameter("vastaus"),request.getParameter("kommentti"), null);
//		System.out.println(a);
//		String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/addanswer";
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Here we create an Entity of a Fish object as JSON string format
//		Entity<Answers> e=Entity.entity(a,MediaType.APPLICATION_JSON);
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
//		
//		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<Answers> returnedList=b.post(e, genericList);
//		return returnedList;
//	}
//	
//	private List<Answers> readanswer(HttpServletRequest request) {
//		String ehdokas_id=request.getParameter("ehdokas_id");
//		String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/readanswer";
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
//		
//		List<Answers> returnedList=b.get(genericList);
//		return returnedList;
//	}
//	
//	private List<Answers> updateanswer(HttpServletRequest request) {
//		//A Fish object to send to our web-service 
//		Answers a=new Answers(request.getParameter("kysymys_id"), request.getParameter("vastaus"), request.getParameter("kommentti"), null);
//		System.out.println(a);
//		String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/updateanswer";
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Here we create an Entity of a Fish object as JSON string format
//		Entity<Answers> e=Entity.entity(a,MediaType.APPLICATION_JSON);
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
//		
//		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<Answers> returnedList=b.put(e, genericList);
//		return returnedList;
//	}
//	
//	private List<Answers> deleteanswer(HttpServletRequest request) {
//		String ehdokas_id=request.getParameter("ehdokas_id");
//		String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/deleteanswer/"+ehdokas_id;
//		Client c=ClientBuilder.newClient();
//		WebTarget wt=c.target(uri);
//		Builder b=wt.request();
//		//Create a GenericType to be able to get List of objects
//		//This will be the second parameter of post method
//		GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
//		
//		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//		List<Answers> returnedList=b.delete(genericList);
//		return returnedList;
//	}
//}