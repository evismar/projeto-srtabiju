// @SOURCE:C:/xampp/htdocs/siteSrtaBijuPlay/conf/routes
// @HASH:82f223158ee0cb1d7ab61f9b26e236c16cc36994
// @DATE:Sat Jan 19 21:16:28 GMT-03:00 2013

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:10
// @LINE:7
// @LINE:6
package controllers {

// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:7
def contato() = {
   Call("GET", "/contato")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        

                      
    
}
                            

// @LINE:10
class ReverseAssets {
    


 
// @LINE:10
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:10
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:7
def contato = JavascriptReverseRoute(
   "controllers.Application.contato",
   """
      function() {
      return _wA({method:"GET", url:"/contato"})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:10
class ReverseAssets {
    


 
// @LINE:10
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:10
// @LINE:7
// @LINE:6
package controllers.ref {

// @LINE:7
// @LINE:6
class ReverseApplication {
    


 
// @LINE:7
def contato() = new play.api.mvc.HandlerRef(
   controllers.Application.contato(), HandlerDef(this, "controllers.Application", "contato", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              

                      
    
}
                            

// @LINE:10
class ReverseAssets {
    


 
// @LINE:10
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                