//package controllers.student;
//
//import models.common.course.Course;
//import models.teacher.Teacher;
//import play.data.Form;
//import play.data.validation.Constraints.Required;
//import play.mvc.Controller;
//import play.mvc.Result;
//
//import static play.data.Form.form;
//
//public class LoginController extends Controller {
//
//	/**
//     * Handle login form submission.
//     *
//     * @return Teacher profile page if login success
//     */
//    public static Result authenticate() {
//        Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
//        if (loginForm.hasErrors()) {
//            return badRequest(views.html.teacherLogin.render(loginForm,ctx().session().get("userName")));
//        } else {
//            session("userName", loginForm.get().userName);
//            Teacher teacher = Teacher.findByUsername(loginForm.get().userName);
//            return ok(views.html.teacherProfile.render(teacher,Course.findByTeacher(teacher),ctx().session().get("userName")));
//        }
//    }
//
//    public static Result loginForm() {
//    	Form<LoginController.LoginForm> teacherLoginForm = form(LoginController.LoginForm.class);
//		return ok(views.html.teacherLogin.render(teacherLoginForm,ctx().session().get("userName")));
//    }
//
//    public static Result signOut(){
//    	ctx().session().clear();
//    	return redirect(controllers.routes.Application.index());
//    }
//
//
//    /**
//     * Login class used by Login Form.
//     */
//    public static class LoginForm {
//
//        @Required
//        public String userName;
//        @Required
//        public String password;
//
//        /**
//         * Validate the authentication.
//         *
//         * @return null if validation ok, string with details otherwise
//         */
//        public String validate() {
//
//            Teacher user = null;
//            user = Teacher.authenticate(userName, password);
//            if (user == null) {
//                return ("Invalid user name or password, please try again.");
//            }
//            return null;
//        }
//
//    }
//
//}
