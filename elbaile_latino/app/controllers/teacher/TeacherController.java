package controllers.teacher;

import static play.data.Form.form;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.common.DanceStyle;
import models.common.Gender;
import models.common.Language;
import models.common.course.Course;
import models.teacher.Teacher;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;



public class TeacherController extends Controller {
	 
	public static Result list(){
		List<Teacher> teachers = Teacher.find.all();
		return ok(views.html.list.render(teachers,ctx().session().get("userName")));
	}
	
	
	public static Result show(String username){
		Teacher teacher = Teacher.findByUsername(username);
		if(teacher == null){
			return notFound();
		} else {
			return ok(views.html.teacherProfile.render(teacher,Course.findByTeacher(teacher),ctx().session().get("userName"),calculateAge(teacher.dateOfBirth)));
		}
	}
	
	public static Result newTeacherForm(){
		
		if(ctx().session().get("userName") != null){
			return redirect(controllers.teacher.routes.TeacherController.show(ctx().session().get("userName")));
		}
		Form<TeacherController.TeacherForm> teacherForm = form(TeacherController.TeacherForm.class);
		return ok(views.html.newTeacher.render(teacherForm,DanceStyle.findAll(),Gender.find.all(),ctx().session().get("userName")));
	}
	
	public static Result createTeacher() throws ParseException{
		Form<TeacherForm> form = form(TeacherForm.class).bindFromRequest();
		if (form.hasErrors()) {    	
			System.out.println("form has errors");
    		return badRequest(views.html.newTeacher.render(form,DanceStyle.findAll(),Gender.find.all(),ctx().session().get("userName")));
        }
		TeacherController.TeacherForm teacherForm = form.get();
		
		Teacher teacher = new Teacher();
		teacher.firstName = teacherForm.firstName;
		teacher.lastName = teacherForm.lastName;
		teacher.userName = teacherForm.userName;
		teacher.gender = Gender.findByName(teacherForm.gender);
		teacher.password = teacherForm.password;
		teacher.email = teacherForm.email;
		teacher.mobile = teacherForm.mobile;
		teacher.imgURL = teacherForm.imgURL;
		teacher.professionalExperience = teacherForm.professionalExperience;
		DateFormat format = new SimpleDateFormat("dd.mm.yyyy");
		teacher.dateOfBirth = format.parse(teacherForm.dateOfBirth);
		teacher.spokenLanguages = getLanguages(teacherForm.spokenLanguages);
		teacher.danceStyles = getDanceStyles(teacherForm.danceStyles);
		teacher.save();
		return redirect(controllers.teacher.routes.LoginController.loginForm());
	}
	

	
	private static List<Language> getLanguages(String languages){
		List<Language> languagesList = new ArrayList<Language>();		
		String []languagesInputs = languages.split(",");
		for(String lang : languagesInputs){
			languagesList.add(Language.findByName(lang));
		}
		return languagesList;
	}
	
	private static List<DanceStyle> getDanceStyles(String stylesString){
		List<DanceStyle> styles = new ArrayList<DanceStyle>();
		String []danceStylesInputs = stylesString.split(",");
		for(String style : danceStylesInputs){
			styles.add(DanceStyle.findByName(style));
		}
		return styles;
	}
	
	private static String calculateAge(Date birthDate){
		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(birthDate);
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(dob.get(Calendar.YEAR));
		System.out.println(birthDate);
		return (now.get(Calendar.YEAR) - dob.get(Calendar.YEAR)) + "";
	}
	
	public static class TeacherForm {
		@Required
        public String firstName;
        @Required
        public String lastName;
        @Required
        public String userName;
        @Required
        public String password;
        @Required
        public String passwordConfirm;
        
        @Required        
        public String email;
        
        @Required        
        public String gender;
        
        @Required        
        public String emailConfirm;
        
        @Required
    	public String mobile;
        @Required
    	public String imgURL;

        public String professionalExperience;        
        
    	public String spokenLanguages;
        @Required
    	public String dateOfBirth;
        
    	public String danceStyles;
        
        public String validate (){
        	if (isBlank(firstName)) {
                return "First name is required";
            }
        	if (isBlank(lastName)) {
                return "Last name is required";
            }       
        	if (isBlank(userName)) {
                return "User Name is required";
            }       
        	if (isBlank(dateOfBirth)) {
                return "Date of birth is required";
            }       
        	if (isBlank(password)) {
                return "Password is required";
            }  
        	if (isBlank(passwordConfirm)) {
                return "Password confirmation is required";
            }  
        	if (isBlank(email)) {
                return "Email is required";
            }       
        	if (isBlank(emailConfirm)) {
                return "Email confirmation is required";
            }       
        	if (isBlank(mobile)) {
                return "Mobile is required";
            }       
        	if (isBlank(spokenLanguages)) {
                return "At least one language is required is required";
            }       
        	if (isBlank(danceStyles)) {
                return "At least one dance style is required is required";
            }       
        	
            return null;
        }
        
        private boolean isBlank(String input) {
            return input == null || input.isEmpty() || input.trim().isEmpty();
        }
        //TODO continue with form validation
        
	}
	
}
