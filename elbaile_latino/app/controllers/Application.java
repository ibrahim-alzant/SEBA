package controllers;

import models.common.course.Course;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        String BACHATA = String.valueOf(Course.getCategoryCoursesCount("BACHATA"));
        String samba = String.valueOf(Course.getCategoryCoursesCount("samba"));
        String tango = String.valueOf(Course.getCategoryCoursesCount("tango"));
        String danza = String.valueOf(Course.getCategoryCoursesCount("danza"));
        String REGGAETON = String.valueOf(Course.getCategoryCoursesCount("REGGAETON"));
        String jive = String.valueOf(Course.getCategoryCoursesCount("jive"));
        String RUMBA = String.valueOf(Course.getCategoryCoursesCount("RUMBA"));
        String SALSA = String.valueOf(Course.getCategoryCoursesCount("SALSA"));
        return ok(views.html.landing.render(ctx().session().get("userName"),BACHATA,samba,tango,danza,REGGAETON,jive,RUMBA,SALSA));
    }

}
