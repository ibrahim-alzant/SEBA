package models.common.course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import models.common.DanceStyle;
import models.common.Language;
import models.teacher.Teacher;
import play.data.validation.Constraints.Required;
import play.db.DB;
import play.db.ebean.Model;

@Entity
public class Course extends Model {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2805734080411815496L;

	@Id
	@GeneratedValue
	public int id;

	@Required
	@ManyToOne	
	public Teacher teacher;

	@Required
	public String title;

	@Required
	public Date startDate;

	@Required
	public int numberOfClasses;

	@Required
	public Integer numberOfParticipants;

	@Required
	public Integer maxNumberOfParticipants ;

	@Required
	@ManyToOne
	public Language language;

	@Required
	@OneToOne
	public DanceStyle danceStyle;

	@Required
	public String danceLevel;

	@Required
	public String status;
	
	public static Finder<Long, Course> find = new Finder<Long, Course>(
			Long.class, Course.class);
	
	public static List<Course> findByTitle(String title){
		return find.where().eq("title", title).findList();
	}
	
	public static List<Course> findByTeacher(Teacher teacher){
		Connection connection = DB.getConnection();
		List<Course> result_list = new ArrayList<>();

		try{
			ResultSet result = connection.prepareStatement(" Select course.id "
					+" from course"
					+" where course.teacher_id="+teacher.id).executeQuery();
			
			connection.close();
			
			while(result.next()){
				
				Long courseId = result.getLong(1);
				Course courseFound = Course.find.byId(courseId);
				result_list.add(courseFound);	
				
			}
					
		}catch(Exception e){
			e.getStackTrace();
			
		}	
		return result_list;
	}

}
