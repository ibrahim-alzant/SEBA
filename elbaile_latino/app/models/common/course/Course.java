package models.common.course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Expr;
import models.common.DanceStyle;
import models.common.Language;
import models.common.TimeSlot;
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

	//TODO use the new fields in the create and details view
	//Add those to the UML
	@Required
	public String location;

	//@ManyToMany
	//public List<TimeSlot> timeSlots;

	@Required
	public float participantFee;

	//TODO Add students list, image and video

	public String pictureURL;
	public String videoURL;
	
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

	public static List<Course> findByKeyword(String keyword){
	//Provided filter courses by title
	//TODO: Filter by dance style, language
	//Note: Used this methodology because  the find() doesn't support more than 2
	// OR in the where statement

		Connection connection = DB.getConnection();
		List<Course> result_list = new ArrayList<>();

		try{
			ResultSet result = connection.prepareStatement(" Select course.id "
					+" from course"
			).executeQuery();

			connection.close();

			while(result.next()){

				Long courseId = result.getLong(1);
				Course courseFound = Course.find.byId(courseId);

				if(courseFound.title.toUpperCase().contains(keyword) || courseFound.status.toUpperCase().contains(keyword) ||
				courseFound.teacher.firstName.toUpperCase().contains(keyword) || courseFound.teacher.lastName.toUpperCase().contains(keyword)||
				courseFound.danceLevel.toUpperCase().contains(keyword) || courseFound.language.languageName.toUpperCase().contains(keyword) ||
				courseFound.danceStyle.danceStyleName.toUpperCase().contains(keyword) || courseFound.startDate.toString().toUpperCase().contains(keyword))
					result_list.add(courseFound);
			}

		}catch(Exception e){
			e.getStackTrace();

		}
		return result_list;
	}

}
