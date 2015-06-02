package controllers.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.common.DanceStyle;
import models.common.Language;
import models.common.course.Course;
import models.teacher.Teacher;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import static play.data.Form.form;


public class CourseController extends Controller {

	public static Result createCourse() {
		Form<CourseForm> form = form(CourseForm.class).bindFromRequest();
		if (form.hasErrors()) {
			return badRequest(views.html.course.newCourse.render(form,DanceStyle.findAll(),ctx().session().get("userName")));
		}
		CourseController.CourseForm courseForm = form.get();
		Course course = new Course();
		course.title = courseForm.title;
		course.maxNumberOfParticipants = courseForm.maxNumberOfParticipants;
		course.numberOfClasses = courseForm.numberOfClasses;
		course.language = Language.findByName(courseForm.language);
		course.startDate = new Date(); //TODO get proper date
		course.danceStyle = DanceStyle.findByName(courseForm.danceStyle);
		
		course.teacher = Teacher.findByUsername(ctx().session().get("userName"));
		course.status = courseForm.status;
		course.danceLevel = courseForm.danceLevel;
		
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
			return ok(views.html.course.coursePage.render(course,ctx().session().get("userName")));
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
		return ok(views.html.course.coursesSearch.render(Course.findByKeyword(keyword),ctx().session().get("userName"), keyword));
	}

	public static Result searchByCategory(String catName){
		String keyword =  catName.toUpperCase();
		return ok(views.html.course.coursesSearch.render(Course.findByKeyword(keyword),ctx().session().get("userName"), keyword));
	}

	public static class CourseForm {

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
