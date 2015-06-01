package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
       return ok(views.html.landing.render(ctx().session().get("userName")));
    }

}
