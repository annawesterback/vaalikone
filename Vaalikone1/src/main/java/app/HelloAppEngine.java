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
	
	
	//t�h�n voi laittaa metodin ett� printtaa tervehdys tai header 

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    
    PrintWriter out = response.getWriter();
    out.print("Hello World");
    //Videolla t�m� copypastettiin showcandidates.jsp st� MUTTA t�h�n lis�ttiin joku reader?
//    ArrayList<Candidates> candidatesList=(ArrayList<Candidates>)request.getAttribute("candidateslist");
//
//    for (int i=0;candidatesList!=null && i<candidatesList.size();i++){
//    	Candidates f=candidatesList.get(i);
//    	out.println(f.getId()+": "+f.getSukunimi()+"<a href='/deletecandidates?id="+f.getId()+"'>deletecandidates</a> <a href='/?id="+f.getId()+"'>editcandidates</a>");
//    }  
    
    //ja t�ss� kutsutaan sit� metodia
    
    // jotain paskaa
    
   // response.getWriter().print("Hello App Engine!\r\n");

  }
}