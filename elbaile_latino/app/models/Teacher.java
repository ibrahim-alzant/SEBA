package models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import models.*;
import play.data.format.Formats;

@Entity
public class Teacher extends Model {

	@Id
	@GeneratedValue
	public Long id;
	@Required
	public String firstName;
	public String lastName;
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

}
