package br.com.antonio.mauricio.projetoweb.configuration;

import br.com.antonio.mauricio.projetoweb.response.ErrorResponse;
import br.com.antonio.mauricio.projetoweb.response.RetornoApiErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionControllerAdvice {

  @ExceptionHandler(RetornoApiErro.class)
  public ResponseEntity<ErrorResponse> exceptionHandlerRetornoApiErro(RetornoApiErro ex) {
    ErrorResponse error = new ErrorResponse();
    error.setErrorCode(ex.getResponseCode());
    error.setMessage(ex.getErrorMessage());
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.valueOf(ex.getResponseCode()));
  }

  @ExceptionHandler(value = {TransactionSystemException.class})
  public ResponseEntity<ErrorResponse> exceptionTransactionSystemException(
      TransactionSystemException ex) {
    Throwable t = ex.getCause();
    if (t.getCause() instanceof ConstraintViolationException) {

      ErrorResponse error = new ErrorResponse();
      error.setErrorCode(HttpServletResponse.SC_BAD_REQUEST);

      StringBuilder messages = new StringBuilder();

      for (ConstraintViolation<?> violation : ((ConstraintViolationException) t.getCause())
          .getConstraintViolations()) {
        messages.append(violation.getMessage());
      }

      error.setMessage(messages.toString());
      return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);

    } else {
      ErrorResponse error = new ErrorResponse();
      error.setErrorCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      error.setMessage(ex.getMessage());
      return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
