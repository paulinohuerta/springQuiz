package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import domain.Pregunta;

@Service
public class PreguntaServiceImpl {
    
    /*
     * this implementation is not thread-safe
     */
    private List<Pregunta> preguntas;
    
    public PreguntaServiceImpl() {
        preguntas = new ArrayList<Pregunta>();
        Pregunta preg1 = new Pregunta(1, "Qien descubre America","Colon","Lopera","Paulino","ninguna",1);
        Pregunta preg2 = new Pregunta(2, "Qien fue campeon","Real Madrid","Sevilla","Betis","ninguna",1);
        Pregunta preg3 = new Pregunta(3, "Estamos en","2018","2017","2011","ninguna",2);
        Pregunta preg4 = new Pregunta(4, "Estamos en el mes de","febrero","marzo","mayo","ninguna",4);
        preguntas.add(preg1);
        preguntas.add(preg2);
        preguntas.add(preg3);
        preguntas.add(preg4);
        
    }
    
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
    public Pregunta getPregunta(int id) {
        /*
        for (Pregunta category : categories) {
            if (id == category.getId()) {
                return category;
            }
        }
        return null;
        */
        if(id <= preguntas.size()) {
          return preguntas.get(id-1);
        }
        return null;
    }

    public void setRespuesta(int i,int j) {
       preguntas.get(i-1).setResp(j);
    }
}
