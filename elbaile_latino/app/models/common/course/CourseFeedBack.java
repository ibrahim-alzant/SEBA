package models.common.course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import models.common.Language;
import models.student.Student;
import models.teacher.Teacher;
import play.data.validation.Constraints.Required;
import play.db.DB;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class CourseFeedBack extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
	public Long id;
	
	@Required
	public String feedbackText;
	
	@ManyToOne
	@Required
	public Student owner;
	
	@Required
	@ManyToOne
	public Course course;
	
	
	
	public static Finder<Long, CourseFeedBack> find = new Finder<Long, CourseFeedBack>(
            Long.class, CourseFeedBack.class);

	public static List<CourseFeedBack> findByCourse(Course course){
		Connection connection = DB.getConnection();
		List<CourseFeedBack> result_list = new ArrayList<>();

		try{
			ResultSet result = connection.prepareStatement(" Select course_feed_back.id "
					+" from course_feed_back"
					+" where course_feed_back.course_id="+course.id).executeQuery();
			
			connection.close();
			
			while(result.next()){
				
				Long courseFeedBackId = result.getLong(1);
				CourseFeedBack courseFeedBackFound = CourseFeedBack.find.byId(courseFeedBackId);
				result_list.add(courseFeedBackFound);	
				
			}
					
		}catch(Exception e){
			e.getStackTrace();
			
		}	
		return result_list;
	}


}
