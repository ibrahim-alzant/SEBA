package controllers.student;

import models.common.DanceStyle;
import models.common.Gender;
import models.common.Language;
import models.student.Student;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.newStudent;
import views.html.newTeacher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static play.data.Form.form;


public class StudentController extends Controller {

    	public static Result list(){
		List<Student> students = Student.find.all();
		return ok(views.html.student_list.render(students,ctx().session().get("userName")));
	}
//
//
	public static Result show(String username){
		Student student = Student.findByUsername(username);
		if(student == null){
			return notFound();
		} else {
            return notFound();
//			return ok(views.html.studentProfile.render(student,Course.findByTeacher(student),ctx().session().get("userName")));
		}
	}

    public static Result newStudentForm() {
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

        if (ctx().session().get("userName") != null) {
            return redirect(controllers.student.routes.StudentController.show(ctx().session().get("userName")));
        }
        Form<StudentController.StudentForm> studentForm = form(StudentController.StudentForm.class);
        return ok(views.html.newStudent.render(studentForm, DanceStyle.findAll(), Gender.find.all(), ctx().session().get("userName")));
    }

    public static Result createStudent(){
        Form<StudentForm> form = form(StudentForm.class).bindFromRequest();
        if (form.hasErrors()) {
            System.out.println("form has errors");
            return badRequest(newStudent.render(form, DanceStyle.findAll(), Gender.find.all(), ctx().session().get("userName")));
        }
        StudentForm studentForm = form.get();

        Student student = new Student();
        student.firstName = studentForm.firstName;
        student.lastName = studentForm.lastName;
        student.userName = studentForm.userName;
        student.gender = Gender.findByName(studentForm.gender);
        student.password = studentForm.password;
        student.email = studentForm.email;
        student.mobile = studentForm.mobile;
        student.imgURL = studentForm.imgURL;
        student.additionalInformation = studentForm.additionalInformation;
        student.height = Integer.parseInt(studentForm.height);
        student.dateOfBirth = new Date(); //TODO
        student.spokenLanguages = getLanguages(studentForm.spokenLanguages);
        student.danceStyles = getDanceStyles(studentForm.danceStyles);
        student.save();
        return redirect(controllers.student.routes.LoginController.loginForm());
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
    public static class StudentForm {
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

        public String mobile;

        public String imgURL;

        public String additionalInformation;

        public String height;

        @Required
        public String spokenLanguages;

        public String dateOfBirth;

        @Required
        public String danceStyles;

        public String validate() {
            if (isBlank(firstName)) {
                return "First name is required";
            }
            if (isBlank(lastName)) {
                return "Last name is required";
            }
            if (isBlank(userName)) {
                return "User Name is required";
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

    }

}
