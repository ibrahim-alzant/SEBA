package controllers.student;

import models.common.DanceStyle;
import models.common.Language;
import models.student.Student;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by Admin on 08.06.2015.
 */
public class PartnerSearchController extends Controller {
    public static Result newPartnerSearchForm(){
        Student student = Student.findByUsername(ctx().session().get("userName"));
        return ok(views.html.partnerSearch.render(ctx().session().get("userName"), DanceStyle.findAll(), student));
    }
}
