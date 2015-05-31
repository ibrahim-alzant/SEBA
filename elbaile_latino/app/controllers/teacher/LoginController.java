package controllers.teacher;

import models.common.course.Course;
import models.teacher.Teacher;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
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
            return badRequest(views.html.teacherLogin.render(loginForm));
        } else {
            session("userName", loginForm.get().userName);            
            Teacher teacher = Teacher.findByUsername(loginForm.get().userName);
            System.out.println(teacher.userName);
            System.out.println("storing username in the session" + ctx().session().get("userName"));
            return ok(views.html.teacherProfile.render(teacher,Course.findByTeacher(teacher)));
        }
    }
    
    public static Result loginForm() {
    	Form<LoginController.LoginForm> teacherLoginForm = form(LoginController.LoginForm.class);
		return ok(views.html.teacherLogin.render(teacherLoginForm));
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

            Teacher user = null;
            user = Teacher.authenticate(userName, password);
            if (user == null) {
                return ("invalid.user.or.password");
            } 
            return null;
        }

    }

}
