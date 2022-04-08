package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Questions;

/**
 * Servlet implementation class ReadToUpdateQuestions
 */
@WebServlet("/readtoupdatequestions")
public class ReadToUpdateQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "vaaliqueen", "kukkuu");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadToUpdateQuestions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		Questions f=null;
		if (dao.getConnection()) {
			f=dao.readQuestions(id);
		}
		request.setAttribute("questionslist", f);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestionstoedit.jsp");
		rd.forward(request, response);
	}

}
