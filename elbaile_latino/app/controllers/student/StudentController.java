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
import views.html.newStudent;
import views.html.newTeacher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static play.data.Form.form;


public class StudentController extends Controller {

    public static Result list() {
        List<Student> students = Student.find.all();
        return ok(views.html.student_list.render(students, ctx().session().get("userName")));
    }

    //
//
    public static Result show(String username) {
        Student student = Student.findByUsername(username);
        StudentProfileController controller = new StudentProfileController();
        List<Course> courses = controller.getCourses(student);
        if (student == null) {
            return notFound();
        } else {
            return ok(views.html.studentProfile.render(student, ctx().session().get("userName"), controller, courses));
        }
    }

    public static Result newStudentForm() {
        Form<StudentController.StudentForm> studentForm = form(StudentController.StudentForm.class);
        if (ctx().session().get("userName") != null) {
//            return redirect(controllers.student.routes.StudentController.show(ctx().session().get("userName")));
            String username = ctx().session().get("userName");
            Student student = Student.findByUsername(username);
            return ok(views.html.editStudent.render(studentForm, DanceStyle.findAll(), Gender.find.all(), username, student));
        }
        return ok(views.html.newStudent.render(studentForm, DanceStyle.findAll(), Gender.find.all(), ctx().session().get("userName")));
    }

    public static Result createStudent() throws ParseException {
        Form<StudentForm> form = form(StudentForm.class).bindFromRequest();
        if (form.hasErrors()) {
            System.out.println("form has errors");
            return badRequest(newStudent.render(form, DanceStyle.findAll(), Gender.find.all(), ctx().session().get("userName")));
        }
        StudentForm studentForm = form.get();
        Student student;
        if (ctx().session().get("userName") != null) {
            student = Student.findByUsername(ctx().session().get("userName"));
            if (student == null) {
                student = new Student();
            }
        } else {
            student = new Student();
        }

        student.firstName = studentForm.firstName;
        student.lastName = studentForm.lastName;
        student.userName = studentForm.userName;
        student.gender = Gender.findByName(studentForm.gender);
        student.password = studentForm.password;
        student.email = studentForm.email;
        student.address = studentForm.address;
        student.mobile = studentForm.mobile;
        student.imgURL = studentForm.imgURL;
        student.additionalInformation = studentForm.additionalInformation;
        student.height = Integer.parseInt(studentForm.height);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        student.dateOfBirth = format.parse(studentForm.dateOfBirth);
        student.spokenLanguages = getLanguages(studentForm.spokenLanguages);
        student.danceStyles = getDanceStyles(studentForm.danceStyles);
        student.save();
        if (ctx().session().get("userName") != null) {
            StudentProfileController controller = new StudentProfileController();
            List<Course> courses = controller.getCourses(student);
            return ok(views.html.studentProfile.render(student, ctx().session().get("userName"), controller, courses));
        }
        return redirect(controllers.student.routes.LoginController.loginForm());
    }

    private static List<Language> getLanguages(String languages) {
        List<Language> languagesList = new ArrayList<Language>();
        String[] languagesInputs = languages.split(",");
        for (String lang : languagesInputs) {
            languagesList.add(Language.findByName(lang));
        }
        return languagesList;
    }

    private static List<DanceStyle> getDanceStyles(String stylesString) {
        List<DanceStyle> styles = new ArrayList<DanceStyle>();
        String[] danceStylesInputs = stylesString.split(",");
        for (String style : danceStylesInputs) {
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
        public String address;
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
