package controllers.teacher;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import models.common.DanceStyle;
import models.common.Language;
import models.common.course.Course;
import models.teacher.Teacher;
import play.data.Form;
import play.data.validation.Constraints;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;



public class TeacherController extends Controller {
	
	public static Result list(){
		List<Teacher> teachers = Teacher.find.all();
		return ok(views.html.list.render(teachers));
	}
	
	
	public static Result show(String username){
		Teacher teacher = Teacher.findByUsername(username);
		if(teacher == null){
			return notFound();
		} else {
			return ok(views.html.teacherProfile.render(teacher));
		}
	}
	
	public static Result newTeacherForm(){
		Form<TeacherController.TeacherForm> teacherForm = form(TeacherController.TeacherForm.class);
		return ok(views.html.newTeacher.render(teacherForm,null));
	}
	
	public static Result createTeacher(){
		Form<TeacherForm> form = form(TeacherForm.class).bindFromRequest();
		if (form.hasErrors()) {    		
    		return badRequest(views.html.newTeacher.render(form,"message"));
        }
		TeacherController.TeacherForm teacherForm = form.get();
		
		Teacher teacher = new Teacher();
		teacher.firstName = teacherForm.firstName;
		teacher.lastName = teacherForm.lastName;
		teacher.userName = teacherForm.userName;
		teacher.email = teacherForm.email;
		teacher.mobile = teacherForm.mobile;
		teacher.imgURL = teacherForm.imgURL;
		teacher.professionalExperience = teacherForm.professionalExperience;
		teacher.dateOfBirth = new Date();
		teacher.nationality = teacherForm.nationality;
		teacher.spokenLanguages = getLanguages(teacherForm.spokenLanguages);
		teacher.danceStyles = getDanceStyles(teacherForm.danceStyles);
		teacher.save();
		return redirect(controllers.teacher.routes.TeacherController.list());
	}
	
	
	
	
	private static List<Language> getLanguages(String languges){
		List<Language> languages = new ArrayList<Language>();		
		//TODO get tokens and for loop
		languages.add(Language.findByName(languges));
		return languages;
	}
	
	private static List<DanceStyle> getDanceStyles(String stylesString){
		List<DanceStyle> styles = new ArrayList<DanceStyle>();
		//TODO get tokens and search base on tokens
		styles.add(DanceStyle.findByName(stylesString));
		return styles;
	}
	
	public static class TeacherForm {
		@Constraints.Required
        public String firstName;
        @Constraints.Required
        public String lastName;
        @Constraints.Required
        public String userName;
        @Constraints.Required        
        public String email;
        @Constraints.Required
    	public String mobile;
        @Constraints.Required
    	public String imgURL;
        @Constraints.Required
    	public String professionalExperience;
        @Constraints.Required
    	public String nationality;
        @Constraints.Required
    	public String spokenLanguages;
        @Constraints.Required
    	public String dateOfBirth;
        @Constraints.Required
    	public String danceStyles;
        
        public String validate (){
        	if (isBlank(firstName)) {
                return "First name is required";
            }
        	if (isBlank(lastName)) {
                return "Last name is required";
            }        	
        	
            return null;
        }
        
        private boolean isBlank(String input) {
            return input == null || input.isEmpty() || input.trim().isEmpty();
        }
        
        
	}
	
}
