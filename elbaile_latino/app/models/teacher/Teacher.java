package models.teacher;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
import models.common.DanceStyle;
import models.common.Language;

@Entity
public class Teacher extends  Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6738879617416559361L;
	@Id
	@GeneratedValue
	public Long id;
	@Required
	public String firstName;
	public String firstkkName;
	public String lastName;
	public String userName;
	public String password;
	public String email;
	public String mobile;
	public String imgURL;
	public String professionalExperience;
	public String nationality;
	public List<Language> spokenLanguages;
	public Date dateOfBirth;
	public List<DanceStyle> danceStyles;

	public static Finder<Long, Teacher> find = new Finder<Long, Teacher>(
			Long.class, Teacher.class);

	public static Teacher findByUsername(String username){
		return find.where().eq("userName", username).findUnique();
	}
	
	public static Teacher authenticate(String userName, String password) {
		Teacher teacher = find.where().eq("userName", userName).findUnique();
		if (teacher != null) {
			// 
			if (teacher.password.equals(password)) {
				return teacher;
			}
		}
		return null;
	}

}
