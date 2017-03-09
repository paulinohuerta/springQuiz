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
import domain.Name;
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

    @RequestMapping(value = "/processForm")
    public String processForm(@ModelAttribute("name") Name name,Model model){
        pregService.setName(name.getName());
        sig.incrNum();
        Pregunta p = pregService.getPregunta(sig.getNum());
        model.addAttribute("pregunta", p);
        return "PregActual";
    }
    @RequestMapping(value = "/list-pregs")
    public String listBooks(Model model){
        logger.info("list-pregs");
        if(pregService.getName()!=null) {
          sig.incrNum();
          Pregunta p = pregService.getPregunta(sig.getNum());
          if(p==null) {
            conn.select(9); 
            for(Pregunta p1 : pregService.getPreguntas()) {
              int i = p1.getId();
              conn.hset(pregService.getName() + ":" + String.valueOf(i),"correcta",p1.getCorrecta());
              conn.hset(pregService.getName() + ":" + String.valueOf(i),"respuesta",pregService.getRespuestas().get(i-1));
            }
            sig.initNum();
            model.addAttribute("name", new Name());
            return "PregName";
          }
          model.addAttribute("pregunta", p);
          return "PregActual";
        }
        else {
          model.addAttribute("name", new Name());
          return "PregName";
        }
    }

    @RequestMapping(value = "/save-pregs")
    public String saveBook(@RequestParam("unapregunta") String valor) {
        logger.info("save-pregs");
        Pregunta p = pregService.getPregunta(sig.getNum());
        pregService.setRespuesta(sig.getNum(),valor);
        return "redirect:/list-pregs";
    }
}
