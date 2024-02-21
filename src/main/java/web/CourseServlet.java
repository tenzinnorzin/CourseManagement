package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dao.CourseDao;
import Model.Course;

/**
 * Servlet implementation class CourseServlet
 */
//review
@WebServlet("/courses")

public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao dao;
	
    public CourseServlet() throws ClassNotFoundException {
        super();
        dao= new CourseDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Course course= new Course();
		// Set the properties of the Course object
	    course.setCourseName(request.getParameter("coursename"));
	    course.setFees(Integer.parseInt(request.getParameter("fees")));
	    course.setCategory(request.getParameter("category"));
	    course.setCourseDuration(Integer.parseInt(request.getParameter("courseduration")));
	    
	    String courseid= request.getParameter("courseid");
	    if(courseid ==null || courseid.isEmpty()) {
	    	dao.addCourse(course);
	    }else
	    {
	    	course.setCourseId(Integer.parseInt(courseid));
	    }
	}

}
