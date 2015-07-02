package controllers.course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.common.DanceStyle;
import models.common.Language;
import models.common.course.Course;
import models.common.course.CourseFeedBack;
import models.common.course.CoursePayment;
import models.common.course.Remarks;
import models.common.course.SearchFilter;
import models.student.Student;
import models.teacher.Teacher;
import play.data.DynamicForm;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Int;
import static play.data.Form.form;


public class CourseController extends Controller {

	public static Result createCourse() {
		Form<CourseForm> form = form(CourseForm.class).bindFromRequest();
		if (form.hasErrors()) {
			return badRequest(views.html.course.newCourse.render(form,DanceStyle.findAll(),ctx().session().get("userName")));
		}
		CourseController.CourseForm courseForm = form.get();

		Course course = new Course();

		if(courseForm.id > 0)
			course.id = courseForm.id;

		course.title = courseForm.title;
		course.numberOfParticipants = courseForm.numberOfParticipants;
		course.maxNumberOfParticipants = courseForm.maxNumberOfParticipants;
		course.numberOfClasses = courseForm.numberOfClasses;
		course.language = Language.findByName(courseForm.language);
		Date courseStartdate;
		try {
			courseStartdate = new SimpleDateFormat("dd.MM.yyyy").parse(courseForm.startDate);
		} catch (ParseException e) {
			courseStartdate = new Date();
		}

		course.startDate = courseStartdate; //TODO get proper date
		course.danceStyle = DanceStyle.findByName(courseForm.danceStyle);
		course.participantFee = courseForm.participantFee;
		course.location = courseForm.location;
		course.locationCode = courseForm.locationCode;
		
		course.teacher = Teacher.findByUsername(ctx().session().get("userName"));
		course.status = courseForm.status;
		course.danceLevel = courseForm.danceLevel;
		course.pictureURL = courseForm.pictureURL;
		course.videoURL = courseForm.videoURL;

		if(courseForm.id > 0)
			course.update();
		else
		course.save();
		return redirect(controllers.teacher.routes.TeacherController.show(ctx().session().get("userName")));
	}
	
	public static Result addComment(){
		System.out.println("inside comment");
		DynamicForm requestData = form().bindFromRequest();
	    String comment = requestData.get("comment");
	    String courseId = requestData.get("courseId");
	    CourseFeedBack feedBack = new CourseFeedBack();
	    feedBack.course = Course.findById(new Integer(courseId));
	    feedBack.feedbackText = comment;
	    feedBack.owner = Student.findByUsername(ctx().session().get("userName"));
	    System.out.println(feedBack.course.title);
	    System.out.println(feedBack.owner.firstName);
	    System.out.println(feedBack.feedbackText);
	    feedBack.save();
	    
		return ok("success");
	}

	public static Result updateCourse() throws ParseException {
		Form<CourseForm> form = form(CourseForm.class).bindFromRequest();

		if (form.hasErrors())
		{
			int courseId = Integer.parseInt(Form.form().bindFromRequest().get("id"));
			Course tmpCourse = Course.findById(courseId);
			List<CourseFeedBack> feedback = CourseFeedBack.findByCourse(tmpCourse);
			return badRequest(views.html.course.coursePage.render(tmpCourse,ctx().session().get("userName"),true, form,null,feedback));
		}

		CourseController.CourseForm courseForm = form.get();

		Course course = new Course();
		course.id = courseForm.id;
		course.title = courseForm.title;
		course.numberOfParticipants = courseForm.numberOfParticipants;
		course.maxNumberOfParticipants = courseForm.maxNumberOfParticipants;
		course.numberOfClasses = courseForm.numberOfClasses;
		course.language = Language.findByName(courseForm.language);
		Date courseStartdate;
		try {
			courseStartdate = new SimpleDateFormat("dd.MM.yy").parse(courseForm.startDate);
		} catch (ParseException e) {
			courseStartdate = new Date();
		}
		course.startDate = courseStartdate;
		course.danceStyle = DanceStyle.findByName(courseForm.danceStyle);
		course.participantFee = courseForm.participantFee;
		course.location = courseForm.location;
		course.locationCode = courseForm.locationCode;

		course.teacher = Teacher.findByUsername(ctx().session().get("userName"));
		course.status = courseForm.status;
		course.danceLevel = courseForm.danceLevel;
		course.pictureURL = courseForm.pictureURL;
		course.videoURL = courseForm.videoURL;

		course.update();

		return redirect(controllers.teacher.routes.TeacherController.show(ctx().session().get("userName")));
	}

	public static Result list() {
		List<Course> courses = Course.find.all();
		return ok(views.html.course.list.render(courses,ctx().session().get("userName")));
	}

	public static Result showByTitle(String title) {
		List<Course> course = Course.findByTitle(title);
		if (course == null) {
			return notFound();
		} else {
			return ok(views.html.course.list.render(course,ctx().session().get("userName")));
		}
	}

	public static Result showById(Long id) {
		Course course = Course.find.byId(id);
		if (course == null) {
			return notFound();
		} else {
			Form<CourseController.CourseForm> courseForm = form(CourseController.CourseForm.class);
			String userName = ctx().session().get("userName");
			Student user = Student.findByUsername(userName);
			List<CourseFeedBack> feedback = CourseFeedBack.findByCourse(course);
			System.out.println("number of feedback for this course is " + feedback.size());
			return ok(views.html.course.coursePage.render(course,userName,false,courseForm,user,feedback));
		}
	}
	

	public static Result editById(Long id) {
		Course course = Course.find.byId(id);
		if (course == null) {
			return notFound();
		} else {
			Form<CourseController.CourseForm> courseForm = form(CourseController.CourseForm.class);
			List<CourseFeedBack> feedback = CourseFeedBack.findByCourse(course);
			return ok(views.html.course.coursePage.render(course,ctx().session().get("userName"),true,courseForm,null,feedback));
		}
	}

	public static Result newCourseForm() {
		Form<CourseController.CourseForm> courseForm = form(CourseController.CourseForm.class);
		return ok(views.html.course.newCourse.render(courseForm,DanceStyle.findAll(),ctx().session().get("userName")));
	}

	private static List<Language> getLanguages(String languges) {
		List<Language> languages = new ArrayList<>();
		// TODO get tokens and for loop
		languages.add(Language.findByName(languges));
		return languages;
	}

	private static List<DanceStyle> getDanceStyles(String stylesString) {
		List<DanceStyle> styles = new ArrayList<DanceStyle>();
		// TODO get tokens and search base on tokens
		styles.add(DanceStyle.findByName(stylesString));
		return styles;
	}

	public static Result searchByKeyword(){
		String keyword =  Form.form().bindFromRequest().get("seachBox").toUpperCase();
		SearchFilter searchCriteria = new SearchFilter();
		return ok(views.html.course.coursesSearch.render(Course.findByKeyword(keyword),ctx().session().get("userName"), keyword, DanceStyle.findAll(),searchCriteria, Language.findAll()));
	}

	public static Result searchByCategory(String catName){
		String keyword =  catName.toUpperCase();
		SearchFilter searchCriteria = new SearchFilter();
		return ok(views.html.course.coursesSearch.render(Course.findByKeyword(keyword),ctx().session().get("userName"), keyword, DanceStyle.findAll(),searchCriteria, Language.findAll()));
	}

	public static Result showPaymentForm(String courseID){
		Course tmpCourse = Course.findById(Integer.parseInt(courseID));
		String amount = String.valueOf(tmpCourse.participantFee);
		Form<CourseController.CoursePaymentForm> paymentForm = form(CourseController.CoursePaymentForm.class);
		return ok(views.html.course.coursePayment.render(ctx().session().get("userName"),amount, courseID,paymentForm));
	}

	public static Result searchByCriteria(){
		String startDateFrom = Form.form().bindFromRequest().get("startDateFrom");
		String startDateTo = Form.form().bindFromRequest().get("startDateTo");
		String danceStyle = Form.form().bindFromRequest().get("danceStyle");
		String language = Form.form().bindFromRequest().get("language");

		SearchFilter searchCriteria = new SearchFilter();
		searchCriteria.dateFrom = startDateFrom;
		searchCriteria.dateTo = startDateTo;
		searchCriteria.danceStyle = danceStyle;
		searchCriteria.language = language;

		String keyword = searchCriteria.getFilterString();

		return ok(views.html.course.coursesSearch.render(Course.findByCriteria(searchCriteria),ctx().session().get("userName"), keyword, DanceStyle.findAll(), searchCriteria, Language.findAll()));
	}

	public static Result showAllCourses(){
		String startDateFrom = "";
		String startDateTo = "";
		String danceStyle = "";
		String language = "";

		SearchFilter searchCriteria = new SearchFilter();
		searchCriteria.dateFrom = startDateFrom;
		searchCriteria.dateTo = startDateTo;
		searchCriteria.danceStyle = danceStyle;
		searchCriteria.language = language;

		String keyword = searchCriteria.getFilterString();

		return ok(views.html.course.coursesSearch.render(Course.findByCriteria(searchCriteria),ctx().session().get("userName"), keyword, DanceStyle.findAll(), searchCriteria, Language.findAll()));
	}

	public static Result showCourseSettings(){
		//TODO: Send the course ID as parameter (will do it later)
		Course tmpCourse = new Course();
		return ok(views.html.course.courseSettings.render(tmpCourse,ctx().session().get("userName")));
	}

	public static Result registerStudent(){
		Student tmpStudent = Student.findByUsername(ctx().session().get("userName"));
		int courseId =  Integer.parseInt(Form.form().bindFromRequest().get("courseId"));
		String remarksMessaage =  Form.form().bindFromRequest().get("questions");
		Course tmpCourse = Course.findById(courseId);

		if(tmpCourse.participants == null)
			tmpCourse.participants = new ArrayList<Student>();

		tmpCourse.participants.add(tmpStudent);

		if(remarksMessaage.length() > 0)
		{
			if(tmpCourse.remarks == null)
				tmpCourse.remarks = new ArrayList<Remarks>();

			Remarks remark = new Remarks(tmpStudent, new Date(), remarksMessaage);
			tmpCourse.remarks.add(remark);
		}

		tmpCourse.save();

		return redirect(controllers.student.routes.StudentController.show(ctx().session().get("userName")));
	}

	public static Result registerStudentAndPay()
	{
		Form<CoursePaymentForm> form = form(CoursePaymentForm.class).bindFromRequest();

		if (form.hasErrors())
		{
			String courseId = Form.form().bindFromRequest().get("courseId");
			String amountValue = Form.form().bindFromRequest().get("amount");
			return ok(views.html.course.coursePayment.render(ctx().session().get("userName"), amountValue, courseId, form));
		}
		//-- Now Register the user
		Student tmpStudent = Student.findByUsername(ctx().session().get("userName"));
		int courseId =  Integer.parseInt(Form.form().bindFromRequest().get("courseId"));
		Course tmpCourse = Course.findById(courseId);

		if(tmpCourse.participants == null)
			tmpCourse.participants = new ArrayList<Student>();

		tmpCourse.participants.add(tmpStudent);

		tmpCourse.save();

		// ---- Now Process the payment
		CourseController.CoursePaymentForm paymentForm = form.get();
		CoursePayment newPayment = new CoursePayment();
		newPayment.paymentType = paymentForm.paymentType;
		newPayment.cardHolderName = paymentForm.cardHolderName;
		newPayment.cardNumber = paymentForm.cardNumber;
		newPayment.expirationDate = paymentForm.expirationDate;
		newPayment.securityCode = paymentForm.securityCode;
		newPayment.amount = paymentForm.amount;
		newPayment.courseId = paymentForm.courseId;
		newPayment.studentId = tmpStudent.id;
		newPayment.paymentDate = new Date();

		newPayment.save();

		return redirect(controllers.student.routes.StudentController.show(ctx().session().get("userName")));
	}

	public static class CourseForm {
		public int id;
		public String title;
		public String startDate;
		public int numberOfClasses;
		public Integer numberOfParticipants;
		public Integer maxNumberOfParticipants;
		public String language;
		public String danceStyle;
		public String danceLevel;
		public String status;
		public String location;
		public String locationCode;
		public float participantFee;
		public String pictureURL;
		public String videoURL;

		public String validate () {
			if (isBlank(title)) {
				return "Title is required";
			}
			if (isBlank(startDate)) {
				return "Start Date is required";
			}
			if (isZeroOrNigative(numberOfClasses)) {
				return "Number of classes is required";
			}
			if (isZeroOrNigative(maxNumberOfParticipants)) {
				return "Max Number of participants is required";
			}
			if (isBlank(language)) {
				return "Language is required";
			}
			if (isBlank(location)) {
				return "Location is required";
			}
			if (isZeroOrNigative(participantFee)) {
				return "Participant Fee is required";
			}
			if (isBlank(danceLevel)) {
				return "Dance Level is required";
			}

			if (isBlank(danceStyle)) {
				return "Dance Level is required";
			}

			return null;
		}

		private boolean isBlank(String input) {
			return input == null || input.length() == 0;
		}
		private boolean isZeroOrNigative(float input) {
			return input <= 0;
		}
	}

	public static class CoursePaymentForm {
		public int id;
		public String paymentType;
		public String cardHolderName;
		public String cardNumber;
		public String expirationDate;
		public String securityCode;

		public long studentId;
		public int courseId;
		public float amount;

		public String validate () {
			if (isBlank(paymentType)) {
				return "Payment Type is required";
			}
			if (isBlank(cardHolderName)) {
				return "Card Holder Name is required";
			}
			if (isBlank(cardNumber)) {
				return "Card Number is required";
			}
			if (isBlank(expirationDate)) {
				return "Expiration Date is required";
			}

			if (isBlank(securityCode)) {
				return "Security Code is required";
			}

			return null;
		}

		private boolean isBlank(String input) {
			return input == null || input.length() == 0;
		}
	}
}
