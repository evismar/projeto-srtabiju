package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import java.util.*;

import models.*;

public class Application extends Controller {

	    public static void index_cliente() {
	        render();
	    }
	    
	    public static void index_adm() {
	        render();
	    }
	    
		public static void login(String usuario, String senha){
			System.out.println(usuario);
		
		}

	}