package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Categorias extends Application{
    public static void cadCategoria() {
        render();
    }

    public static void salvarCadastro(Categoria categoria){
        
        categoria.create();
        flash.success("Categoria cadastrada!");
        Application.index();
    }

}
