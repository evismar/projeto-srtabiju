
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Srta Biju")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*10.48*/routes/*10.54*/.Assets.at("stylesheets/layout.css"))),format.raw/*10.90*/("""" />
	<link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*11.48*/routes/*11.54*/.Assets.at("stylesheets/base.css"))),format.raw/*11.88*/("""" />
	<link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*12.48*/routes/*12.54*/.Assets.at("stylesheets/right.css"))),format.raw/*12.89*/("""" />

	<script type="text/javascript" src=""""),_display_(Seq[Any](/*14.39*/routes/*14.45*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*14.90*/(""""></script>
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*15.39*/routes/*15.45*/.Assets.at("javascripts/jquery.jcarousel.min.js"))),format.raw/*15.94*/(""""></script>
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*16.39*/routes/*16.45*/.Assets.at("javascripts/jquery.slide.js"))),format.raw/*16.86*/(""""></script>
	<script language="javascript">
		$(document).ready(function ()"""),format.raw("""{"""),format.raw/*18.33*/("""
					$("#slideimg").PikaChoose("""),format.raw("""{"""),format.raw/*19.33*/("""carousel:true, carouselVertical:true"""),format.raw("""}"""),format.raw/*19.70*/(""");
				"""),format.raw("""}"""),format.raw/*20.6*/(""");
	</script>
	<script type="text/javascript">
	function submeter(pAcao) """),format.raw("""{"""),format.raw/*23.28*/("""
		
		if (pAcao =="produto")
			alert("Função 'Produtos' ainda não implementada.")
			
		if (pAcao =="minhaConta")
			alert("Função 'Minha Conta' ainda não implementada.")
				
		if (pAcao =="empresa")
			alert("Função 'Empresa' ainda não implementada.")		
				
		if (pAcao =="contato")
			alert("Função 'Contato' ainda não implementada.")
			
		if (pAcao =="pesquisa")
			alert("Função 'Pesquisa' ainda não implementada.")	
		
	
	"""),format.raw("""}"""),format.raw/*41.3*/("""
</script>
        
<title>S4I - Srta.Biju</title>
</head>

<body>


<div id="topo">
	<div id="dentrotopo">
    	<img src=""""),_display_(Seq[Any](/*52.17*/routes/*52.23*/.Assets.at("images/Logo.png"))),format.raw/*52.52*/("""" alt="Logo" />
        <input type="image" src=""""),_display_(Seq[Any](/*53.35*/routes/*53.41*/.Assets.at("images/botaopesq.png"))),format.raw/*53.75*/("""" alt="Buscar..." id="botaoBusca" onclick="submeter('pesquisa')"/>
        <input type="text" name="pesquisa" placeholder="Digite sua pesquisa..." style="border:none; background-color: none" />
	</div>
</div>

<div id="menu">
	<div id="dentromenu">
    	<ul>
    	<li><a href="" class="links"> Home</a></li>
		<li><a href="" class="links" onclick = "submeter('produto')" > Produtos</a></li>
		<li><a href="" class="links" onclick = "submeter('minhaConta')"> Minha Conta</a></li>
		<li><a href="" class="links" onclick = "submeter('empresa')"> A Empresa</a></li>
		<li><a href="" class="links" onclick = "submeter('contato')"> Contato</a></li>
        </ul>
    </div>
</div>

<div id="conteudo">

	<div id="barramenu">
    	<div id="login">
        	<b>Minha Conta</b>
        </div>
    </div>
    
	<div class="slide">
	<h1>Bem-Vindo!</h1>
		<ul class="jcarousel-skin" id="slideimg" name="slideimg">
			<li><a href=""><img src=""""),_display_(Seq[Any](/*81.30*/routes/*81.36*/.Assets.at("images/Slide/1.jpg"))),format.raw/*81.68*/(""""/></a><span>Pulseira trançada com pedrinhas.</span></li>
			<li><a href=""><img src=""""),_display_(Seq[Any](/*82.30*/routes/*82.36*/.Assets.at("images/Slide/2.jpg"))),format.raw/*82.68*/(""""/></a><span>Lançamento! Pulseiras com cores variadas</span></li>
			<li><a href=""><img src=""""),_display_(Seq[Any](/*83.30*/routes/*83.36*/.Assets.at("images/Slide/3.jpg"))),format.raw/*83.68*/(""""/></a><span>Conheça nossos pordutos!</span></li>
			<li><a href=""><img src=""""),_display_(Seq[Any](/*84.30*/routes/*84.36*/.Assets.at("images/Slide/4.jpg"))),format.raw/*84.68*/(""""/></a><span>Pulseira elegante.</span></li>
			<li><a href=""><img src=""""),_display_(Seq[Any](/*85.30*/routes/*85.36*/.Assets.at("images/Slide/5.jpg"))),format.raw/*85.68*/(""""/></a><span>Pulseira banhada a ouro.</span></li>
		</ul>
	</div>
     
	<h3>Conheça nossa</h3>
	<h1>Vitrine !</h1>

	<div id="barra">
    </div>
       
</div>

<div id="rodape">
	<b>© 2013 - S4Info. Todos os Direitos Reservados.</b>
</div>


</form>
</body>
</html>
""")))})))}
    }
    
    def render(message:String) = apply(message)
    
    def f:((String) => play.api.templates.Html) = (message) => apply(message)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 21 11:42:09 GMT-03:00 2013
                    SOURCE: C:/xampp/htdocs/siteSrtaBijuPlay/app/views/index.scala.html
                    HASH: 7d2a678fcf8f5a49bf8962da47069370f73d809b
                    MATRIX: 755->1|849->18|888->23|913->40|952->42|1289->343|1304->349|1362->385|1451->438|1466->444|1522->478|1611->531|1626->537|1683->572|1765->618|1780->624|1847->669|1934->720|1949->726|2020->775|2107->826|2122->832|2185->873|2310->951|2391->985|2475->1022|2530->1031|2654->1108|3150->1558|3321->1693|3336->1699|3387->1728|3474->1779|3489->1785|3545->1819|4540->2778|4555->2784|4609->2816|4733->2904|4748->2910|4802->2942|4934->3038|4949->3044|5003->3076|5119->3156|5134->3162|5188->3194|5298->3268|5313->3274|5367->3306
                    LINES: 27->1|30->1|32->3|32->3|32->3|39->10|39->10|39->10|40->11|40->11|40->11|41->12|41->12|41->12|43->14|43->14|43->14|44->15|44->15|44->15|45->16|45->16|45->16|47->18|48->19|48->19|49->20|52->23|70->41|81->52|81->52|81->52|82->53|82->53|82->53|110->81|110->81|110->81|111->82|111->82|111->82|112->83|112->83|112->83|113->84|113->84|113->84|114->85|114->85|114->85
                    -- GENERATED --
                */
            