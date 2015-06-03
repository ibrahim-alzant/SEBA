package models.common;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class TimeSlot extends Model{
	
	@Id
	@GeneratedValue
	public Long id;	
	
	@Required
	public String dayOfTheWeek;

	@Required
	public String time;

}
