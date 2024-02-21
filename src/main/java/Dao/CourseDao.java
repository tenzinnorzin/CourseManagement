package Dao;
import Model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDao {
	public void addCourse(Course course){
		try {
			
			Connection con;
			con = DbConnect.getConnection();
			String q= "insert into courses (coursename, fees, category, duration) values(?,?,?,?)";
			PreparedStatement pst= con.prepareStatement(q);
	
			pst.setString(1, course.getCourseName());
			pst.setInt(2, course.getFees());
			pst.setString(3, course.getCategory());
			pst.setInt(4, course.getCourseDuration());
			System.out.println(pst);

			pst.executeUpdate();
			
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
