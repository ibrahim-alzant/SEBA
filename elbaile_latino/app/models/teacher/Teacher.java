package models.teacher;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import models.common.DanceStyle;
import models.common.Language;
import play.data.format.Formats;

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
	
	@Required
	public String lastName;
	
	@Required
	@Column(unique = true)
	public String userName;
	
	@Required	
	public String password;
	
	@Required
	@Column(unique = true)
	public String email;
	
	@Required
	public String mobile;

	public String imgURL;	
	
	public String professionalExperience;
	
	@Required
	@ManyToMany(cascade = CascadeType.ALL)
	public List<Language> spokenLanguages;
	
	@Required
	@Formats.DateTime(pattern = "dd-MM-yyyy HH:mm:ss")
	public Date dateOfBirth;
	
	@Required
	@ManyToMany(cascade = CascadeType.ALL)
	public List<DanceStyle> danceStyles;

	public static Finder<Long, Teacher> find = new Finder<Long, Teacher>(
			Long.class, Teacher.class);

	public static Teacher findByUsername(String username){
		return find.where().eq("userName", username).findUnique();
	}
	
	public static Teacher authenticate(String userName, String password) {
		Teacher teacher = find.where().eq("userName", userName).findUnique();
		if (teacher != null) {
			if (teacher.password.equals(password)) {
				return teacher;
			}
		}
		return null;
	}

}
