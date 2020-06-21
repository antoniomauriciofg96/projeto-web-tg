package br.com.antonio.mauricio.projetoweb.utils;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class DateAux implements Serializable {

  private static final long serialVersionUID = 1L;

  public static Date now() {
    return new Date();
  }

}
