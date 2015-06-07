package controllers.student;

import models.common.course.Course;
import models.student.Student;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static play.data.Form.form;

public class LoginController extends Controller {
	
	/**
     * Handle login form submission.
     *
     * @return Teacher profile page if login success
     */
    public static Result authenticate() {
        Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(views.html.studentLogin.render(loginForm,ctx().session().get("userName")));
        } else {
            session("userName", loginForm.get().userName);
            Student student = Student.findByUsername(loginForm.get().userName);
            return ok(views.html.studentProfile.render(student, ctx().session().get("userName"), new StudentProfileController()));
        }
    }
    
    public static Result loginForm() {
    	Form<LoginController.LoginForm> studentLoginForm = form(LoginController.LoginForm.class);
		return ok(views.html.studentLogin.render(studentLoginForm,ctx().session().get("userName")));
    }
    
    public static Result signOut(){
    	ctx().session().clear();
    	return redirect(controllers.routes.Application.index());
    }
    
    
    /**
     * Login class used by Login Form.
     */
    public static class LoginForm {

        @Required
        public String userName;
        @Required
        public String password;

        /**
         * Validate the authentication.
         *
         * @return null if validation ok, string with details otherwise
         */
        public String validate() {

            Student user = null;
            user = Student.authenticate(userName, password);
            if (user == null) {
                return ("Invalid user name or password, please try again.");
            } 
            return null;
        }

    }

}
