package models.common.course;

import models.common.DanceStyle;
import models.common.Language;
import models.student.Student;
import models.teacher.Teacher;
import play.data.validation.Constraints.Required;
import play.db.DB;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CoursePayment extends Model {

	private static final long serialVersionUID = -2805734080411815496L;

	@Id
	@GeneratedValue
	public int id;

	@Required
	public long studentId;

	@Required
	public int courseId;

	@Required
	public String paymentType;

	@Required
	public String cardHolderName;

	@Required
	public String cardNumber;

	@Required
	public String expirationDate;

	@Required
	public String securityCode;

	@Required
	public float amount;

	@Required
	public Date paymentDate;
	
	public static Finder<Long, CoursePayment> find = new Finder<Long, CoursePayment>(
			Long.class, CoursePayment.class);

	public static List<CoursePayment> findByCourseId(int courseId){
		return find.where().eq("courseId", courseId).findList();
	}

	public static CoursePayment findById(int coursePaymentId){
		return find.where().eq("id", coursePaymentId).findUnique();
	}

}
