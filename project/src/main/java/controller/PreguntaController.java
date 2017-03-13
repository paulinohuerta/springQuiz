package controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.Scope;
import redis.clients.jedis.Jedis;
import service.PreguntaServiceImpl;
import service.Siguiente;
import domain.Pregunta;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@Scope("session")
public class PreguntaController {

    @Autowired
    private PreguntaServiceImpl pregService;
    @Autowired
    private Siguiente sig;
    
    private Jedis conn = new Jedis("localhost");

    private static final Log logger = LogFactory.getLog(PreguntaController.class);


    @RequestMapping(value = "/list-pregs")
    public String listBooks(Model model){
        logger.info("list-pregs");
        sig.incrNum();
        Pregunta p = pregService.getPregunta(sig.getNum());
        if(p==null) {
          conn.select(9); 
          for(Pregunta p1 : pregService.getPreguntas()) {
            conn.hset("paulino:" + String.valueOf(p1.getId()),"correcta",String.valueOf(p1.getCorrecta()));
            conn.hset("paulino:" + String.valueOf(p1.getId()),"respuesta",String.valueOf(p1.getResp()));
          }
          sig.initNum();
          p = pregService.getPregunta(sig.getNum());

          int contador=pregService.getContador();
            logger.info("entra");
            model.addAttribute("contador", contador);
            return "Puntuacion";
        }
        model.addAttribute("pregunta", p);
        return "PregActual";
    }
    @RequestMapping(value = "/save-pregs")
    public String saveBook(@RequestParam("unapregunta") String valor) {
        logger.info("save-pregs");
        int v1 = Integer.parseInt(valor);
        Pregunta p = pregService.getPregunta(sig.getNum());
        logger.info(p+"");
        if(p==null) {
            int contador=pregService.getContador();
            logger.info("entra");
            return "Puntuacion";
            
        }
        pregService.setRespuesta(sig.getNum(),v1);
        return "redirect:/list-pregs";
        
    }
}
