package models.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class DanceStyle extends Model{
	
	@Id
	@GeneratedValue
	public Long id;	
	
	@Required
	@Column(unique = true)
	public String danceStyleName;
	
	public static Finder<Long, DanceStyle> find = new Finder<Long, DanceStyle>(Long.class, DanceStyle.class);
	
	public static DanceStyle findByName(String danceStyleName){
		return find.where().eq("danceStyleName", danceStyleName).findUnique();
	}
	

}
