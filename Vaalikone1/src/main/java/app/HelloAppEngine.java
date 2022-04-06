package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/ShowCandidates"}
)
public class HelloAppEngine extends HttpServlet {
	
	
	//tähän voi laittaa metodin että printtaa tervehdys tai header 

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    
    PrintWriter out = response.getWriter();
    out.print("Hello World");
    //Videolla tämä copypastettiin showcandidates.jsp stä MUTTA tähän lisättiin joku reader?
//    ArrayList<Candidates> candidatesList=(ArrayList<Candidates>)request.getAttribute("candidateslist");
//
//    for (int i=0;candidatesList!=null && i<candidatesList.size();i++){
//    	Candidates f=candidatesList.get(i);
//    	out.println(f.getId()+": "+f.getSukunimi()+"<a href='/deletecandidates?id="+f.getId()+"'>deletecandidates</a> <a href='/?id="+f.getId()+"'>editcandidates</a>");
//    }  
    
    //ja tässä kutsutaan sitä metodia
    
    // jotain paskaa
    
   // response.getWriter().print("Hello App Engine!\r\n");

  }
}