package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(views.html.index.render("Teste"));
  }
  public static Result contato() {
    return ok(index.render("Contato"));
  }
  
}