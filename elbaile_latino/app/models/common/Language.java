package models.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * This class represents the available languages that the user can speak.
 * 
 * @author ibrahim alzant
 *
 */
@Entity
public class Language extends Model {
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(unique = true)
	@Required
	public String languageName;

	public static Finder<Long, Language> find = new Finder<Long, Language>(
			Long.class, Language.class);
	
	public static Language findByName(String languageName){
		return find.where().eq("languageName", languageName).findUnique();
	}

}
