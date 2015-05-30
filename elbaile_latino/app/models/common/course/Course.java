package models.common.course;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.common.DanceStyle;
import models.common.Language;
import models.teacher.Teacher;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Course extends Model {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2805734080411815496L;

	@Id
	@GeneratedValue
	public int id;

	public Teacher teacher;

	@Required
	public String title;

	@Required
	public Date startDate;

	@Required
	public int numberOfClasses;

	@Required
	public Integer numberOfParticipants;

	public Integer maxNumberOfParticipants ;

	public Language language;

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

//	public static Course findByDanceStyle(String danceStyle){
//		return find.where().eq("DanceStyle", courseName).findUnique();
//	}

}
