package br.com.antonio.mauricio.projetoweb.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUser {

  private String token;
  private Date expiration_date;

  public TokenUser() {}

  public TokenUser(String token, Date expiration_date) {
    this.token = token;
    this.expiration_date = expiration_date;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getExpiration_date() {
    return expiration_date;
  }

  public void setExpiration_date(Date expiration_date) {
    this.expiration_date = expiration_date;
  }

  @Override
  public String toString() {
    return "Token{" + "token=" + token + ", expiration_date=" + expiration_date + "}";
  }



}
