package controllers.student;

import models.common.DanceStyle;
import models.common.Gender;
import models.common.Language;
import models.common.course.Course;
import models.student.Student;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static play.data.Form.form;


public class StudentController extends Controller {

    //	public static Result list(){
//		List<Student> students = Student.find.all();
////		return ok(views.html.list.render(students,ctx().session().get("userName")));
//	}
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
        if (ctx().session().get("userName") != null) {
            return redirect(controllers.student.routes.StudentController.show(ctx().session().get("userName")));
        }
        Form<StudentController.StudentForm> studentForm = form(StudentController.StudentForm.class);
        return ok(views.html.newStudent.render(studentForm, DanceStyle.findAll(), Gender.find.all(), ctx().session().get("userName")));
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

        public String professionalExperience;

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
        //TODO continue with form validation

    }

}
