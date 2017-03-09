package service;

import org.springframework.stereotype.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
@Service
//@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
@Scope("session")
public class Siguiente {
  private int num;
  public Siguiente() {
    num=0;
  }
  public void incrNum() {
    num++;
  }
  public void setNum(int p) {
    num=p;
  }
  public int getNum() {
    return num;
  }
  public void initNum() {
    num=0;
  }
}
