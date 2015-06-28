package controllers.course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.common.DanceStyle;
import models.common.Language;
import models.common.course.Course;
import models.common.course.SearchFilter;
import models.student.Student;
import models.teacher.Teacher;
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
			return ok(views.html.course.coursePage.render(course,ctx().session().get("userName"),false));
		}
	}

	public static Result editById(Long id) {
		Course course = Course.find.byId(id);
		if (course == null) {
			return notFound();
		} else {
			return ok(views.html.course.coursePage.render(course,ctx().session().get("userName"),true));
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

	public static Result showPaymentForm(){
		String amount = Form.form().bindFromRequest().get("amount");
		String courseId = Form.form().bindFromRequest().get("courseId");
		return ok(views.html.course.coursePayment.render(ctx().session().get("userName"),amount, courseId));
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

	public static Result showCourseSettings(){
		//TODO: Send the course ID as parameter (will do it later)
		Course tmpCourse = new Course();
		return ok(views.html.course.courseSettings.render(tmpCourse,ctx().session().get("userName")));
	}

	public static Result registerStudent(){
		Student tmpStudent = Student.findByUsername(ctx().session().get("userName"));
		int courseId =  Integer.parseInt(Form.form().bindFromRequest().get("courseId"));
		Course tmpCourse = Course.findById(courseId);

		if(tmpCourse.participants == null)
			tmpCourse.participants = new ArrayList<Student>();

		tmpCourse.participants.add(tmpStudent);
		tmpCourse.save();

		return redirect(controllers.student.routes.StudentController.show(ctx().session().get("userName")));
	}

	public static class CourseForm {

		public int id;

		@Required
		public String title;

		@Required
		public String startDate;

		@Required
		public int numberOfClasses;

		@Required
		public Integer numberOfParticipants;

		@Required
		public Integer maxNumberOfParticipants;

		@Required
		public String language;

		@Required
		public String danceStyle;

		@Required
		public String danceLevel;

		@Required
		public String status;

		@Required
		public String location;

		public String locationCode;

		@Required
		public float participantFee;

		public String pictureURL;

		public String videoURL;

		public String validate() {
			if (isBlank(title)) {
				return "title is required";
			}
			if (isBlank(danceStyle)) {
				return "Dance style is required";
			}

			return null;
		}

		private boolean isBlank(String input) {
			return input == null || input.isEmpty() || input.trim().isEmpty();
		}
	}
}
