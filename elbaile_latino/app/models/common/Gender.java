package models.common;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.common.course.Course;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Gender extends Model {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Required
	@Column(unique = true)
	public String genderName;
	
	public static Finder<Long, Gender> find = new Finder<Long, Gender>(
			Long.class, Gender.class);
	
	public static Gender findByName(String name){
		return find.where().eq("genderName", name).findUnique();
	}

}
