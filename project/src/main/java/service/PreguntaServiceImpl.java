package service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import redis.clients.jedis.Jedis;

import org.springframework.stereotype.Service;

import domain.Pregunta;

@Service
public class PreguntaServiceImpl {
    
    /*
     * this implementation is not thread-safe
     */
    private Jedis conn = new Jedis("localhost");
    private List<Pregunta> preguntas;
    
    public PreguntaServiceImpl() {
        preguntas = new ArrayList<Pregunta>();
        conn.select(9);
        preguntas = new ArrayList<Pregunta>();
        for(String st : conn.smembers("quiz:set")) {
            String texto=conn.hget("quiz:hash:" + st,"texto");
            String link=conn.hget("quiz:hash:" + st,"link");
            String op1=conn.hget("quiz:hash:" + st,"op1");
            String op2=conn.hget("quiz:hash:" + st,"op2");
            String op3=conn.hget("quiz:hash:" + st,"op3");
            String op4=conn.hget("quiz:hash:" + st,"op4");
            String well=conn.hget("quiz:hash:" + st,"well");
            preguntas.add(new Pregunta(Integer.parseInt(st), texto, link,op1,op2,op3,op4,Integer.parseInt(well)));
        }
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
