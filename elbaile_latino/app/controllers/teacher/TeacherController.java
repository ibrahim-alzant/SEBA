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
import play.Application;
import play.data.Form;
import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import play.api.Play;
import play.api.libs.Files;
import play.mvc.BodyParser;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Security;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TeacherController extends Controller {

	private static final int MAX_LENGTH = 100 * 1024 * 1024;

	public static Result list() {
		List<Teacher> teachers = Teacher.find.all();
		return ok(views.html.list.render(teachers,
				ctx().session().get("userName")));
	}

	public static Result show(String username) {
		Teacher teacher = Teacher.findByUsername(username);
		if (teacher == null) {
			return notFound();
		} else {
			return ok(views.html.teacherProfile.render(teacher,
					Course.findByTeacher(teacher),
					ctx().session().get("userName"),
					calculateAge(teacher.dateOfBirth)));
		}
	}

	@BodyParser.Of(value = BodyParser.AnyContent.class, maxLength = MAX_LENGTH)
	public static Result uploadfile() {
		MultipartFormData body2 = request().body().asMultipartFormData();
		FilePart img = body2.getFile("file");
		if (img != null) {
			String extension = "";
			File source = img.getFile();
			int i = img.getFilename().lastIndexOf('.');
			if (i > 0) {
			    extension = img.getFilename().substring(i+1);
			}
			String fileName = (new Date().getTime()+"."+extension);
			File destination =new File(play.Play.application().path().getPath()+"/public/images/users/"+ fileName); 
			InputStream inStream = null;
			OutputStream outStream = null;
		 
		    	try{
		    	    inStream = new FileInputStream(source);
		    	    outStream = new FileOutputStream(destination);
		    	    byte[] buffer = new byte[1024];
		    	    int length;
		    	    //copy the file content in bytes 
		    	    while ((length = inStream.read(buffer)) > 0){
		    	    	outStream.write(buffer, 0, length);
		    	    }
		    	    inStream.close();
		    	    outStream.close();
		    	}catch(IOException e){
		    		e.printStackTrace();
		    	}
			return ok("/assets/images/users/" + fileName);
		} else {
			return ok("Failed to upload");
		}
	}

	public static Result newTeacherForm() {

		if (ctx().session().get("userName") != null) {
			return redirect(controllers.teacher.routes.TeacherController
					.show(ctx().session().get("userName")));
		}
		Form<TeacherController.TeacherForm> teacherForm = form(TeacherController.TeacherForm.class);
		return ok(views.html.newTeacher.render(teacherForm,
				DanceStyle.findAll(), Gender.find.all(),
				ctx().session().get("userName")));
	}

	public static Result createTeacher() throws ParseException {
		Form<TeacherForm> form = form(TeacherForm.class).bindFromRequest();
		if (form.hasErrors()) {
			System.out.println("form has errors");
			return badRequest(views.html.newTeacher.render(form, DanceStyle
					.findAll(), Gender.find.all(),
					ctx().session().get("userName")));
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

	private static String calculateAge(Date birthDate) {
		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(birthDate);
		return (now.get(Calendar.YEAR) - dob.get(Calendar.YEAR)) + "";
	}

	public static class TeacherForm {
		public String firstName;
		public String lastName;
		public String userName;
		public String password;
		public String passwordConfirm;
		public String email;
		public String gender;
		public String emailConfirm;
		public String mobile;
		public String imgURL;
		public String professionalExperience;
		public String spokenLanguages;
		@Formats.DateTime(pattern = "dd.MM.yyyy")
		public String dateOfBirth;
		public String danceStyles;

		public String validate() {
			if (isBlank(firstName)) {
				return "First name is required";
			} else if (isBlank(lastName)) {
				return "Last name is required";
			} else if (isBlank(userName)) {
				return "User Name is required";
			} else if (isBlank(dateOfBirth)) {
				return "Date of birth is required";
			} else if (isBlank(password)) {
				return "Password is required";
			} else if (isBlank(passwordConfirm)) {
				return "Password confirmation is required";
			} else if (isBlank(email)) {
				return "Email is required";
			} else if (isBlank(emailConfirm)) {
				return "Email confirmation is required";
			} else if (isBlank(mobile)) {
				return "Mobile is required";
			} else if (isBlank(spokenLanguages)) {
				return "At least one language is required ";
			} else if (isBlank(danceStyles)) {
				return "At least one dance style is required ";
			} else if (!validateDate(dateOfBirth)) {
				return "Date format is not correct. please enter date in this format: 'dd.MM.yyyy'";
			} else if (userNameUsed(userName)) {
				return "username is already in use, please enter another username";
			} else if (!password.equals(passwordConfirm)) {
				return "password confirmation does not match password";
			} else if (!(email.equals(emailConfirm))) {
				return "email confirmation does not match email";
			}

			return null;
		}

		private boolean isBlank(String input) {
			return input == null || input == "" || input.trim().isEmpty();
		}

		private boolean validateDate(String dateOfBirth) {
			DateFormat format = new SimpleDateFormat("dd.mm.yyyy");
			try {
				format.parse(dateOfBirth);
				return true;
			} catch (ParseException e) {
				return false;
			}
		}

		private boolean userNameUsed(String username) {
			Teacher teacher = Teacher.findByUsername(username);
			return !(teacher == null);
		}

	}

}
