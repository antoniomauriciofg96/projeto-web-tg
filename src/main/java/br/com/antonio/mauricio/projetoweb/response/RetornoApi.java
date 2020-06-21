package br.com.antonio.mauricio.projetoweb.response;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class RetornoApi {

  public RetornoApi(Object response) {
    this.responseCode = HttpServletResponse.SC_OK;
    this.data = new SimpleDateFormat("dd/MM/yyyy")
        .format(Date.from(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant()));
    this.response = response;
  }

  private String msg;
  private Integer responseCode;
  private String data;
  private Object response;

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Integer getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(Integer responseCode) {
    this.responseCode = responseCode;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Object getResponse() {
    return response;
  }

  public void setResponse(Object response) {
    this.response = response;
  }

}
