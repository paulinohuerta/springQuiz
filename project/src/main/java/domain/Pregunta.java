package domain;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class Pregunta implements Serializable {
    private static final long serialVersionUID = 5658716793957904104L;
    @Id
    private int id;
    private String texto;
    private String link;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    @Column(name = "well")
    private String correcta;
    
    public Pregunta() {
       this.texto="";
    }
    public Pregunta(int id, String texto,String link, String op1, String op2, String op3, String op4,String correcta) {
        this.id = id;
        this.texto = texto;
        this.link = link;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.correcta = correcta;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    public String getLink() {
        return this.link;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getOp1() {
        return op1;
    }
    public void setOp1(String op1) {
        this.op1 = op1;
    }
    public String getOp2() {
        return op2;
    }
    public void setOp2(String op2) {
        this.op2 = op2;
    }
    public String getOp3() {
        return op3;
    }
    public void setOp3(String op3) {
        this.op3 = op3;
    }
    public String getOp4() {
        return op4;
    }
    public void setOp4(String op4) {
        this.op4 = op4;
    }
    public String getCorrecta() {
        return correcta;
    }
    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }
}
