package controllers.teacher;

import static play.data.Form.form;

import java.util.ArrayList;
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
			return ok(views.html.teacherProfile.render(teacher,Course.findByTeacher(teacher),ctx().session().get("userName")));
		}
	}
	
	public static Result newTeacherForm(){
		Language l1  = new Language();
		l1.languageName = "Arabic";
		Language l2  = new Language();
		l2.languageName = "English";
		Language l3  = new Language();
		l3.languageName = "German";
		Language l4  = new Language();
		l4.languageName = "French";
		
		DanceStyle s1 = new DanceStyle();
		s1.danceStyleName = "Salsa";
		
		DanceStyle s2 = new DanceStyle();
		s2.danceStyleName = "Samba";
		
		DanceStyle s3 = new DanceStyle();
		s3.danceStyleName = "Tango";
		
		Gender g1 = new Gender();
		g1.genderName = "Male";
		
		Gender g2 = new Gender();
		g2.genderName = "Female";
		
//		l1.save();
//		l2.save();
//		l3.save();
//		l4.save();
//		
//		s1.save();
//		s2.save();
//		s3.save();
//		
//		g1.save();
//		g2.save();
		
		if(ctx().session().get("userName") != null){
			return redirect(controllers.teacher.routes.TeacherController.show(ctx().session().get("userName")));
		}
		Form<TeacherController.TeacherForm> teacherForm = form(TeacherController.TeacherForm.class);
		return ok(views.html.newTeacher.render(teacherForm,DanceStyle.findAll(),Gender.find.all(),ctx().session().get("userName")));
	}
	
	public static Result createTeacher(){
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
		teacher.imgURL = "img.jpg";
		teacher.professionalExperience = teacherForm.professionalExperience;
		teacher.dateOfBirth = new Date(); //TODO
		teacher.spokenLanguages = getLanguages(teacherForm.spokenLanguages);
		teacher.danceStyles = getDanceStyles(teacherForm.danceStyles);
		teacher.save();
		return redirect(controllers.teacher.routes.LoginController.loginForm());
	}
	
//	public static Result upload() {
//		  File file = request().body().asRaw().asFile();
//		  return ok("File uploaded");
//		}
//	
	
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
