package models.common.course;

import models.student.Student;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Remarks extends Model {

	@Id
	@GeneratedValue
	public Long id;

	@OneToOne
	public Student student;
	public Date remarkDate;
	public String remarkMessage;
	public boolean isNew;

	public Remarks(Student remarkBy, Date remarkAt, String remarkContent)
	{
		this.student = remarkBy;
		this.remarkDate = remarkAt;
		this.remarkMessage = remarkContent;
		this.isNew = true;
	}
}
