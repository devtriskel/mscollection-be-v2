
/*
 * **********************************************************************
 * 2020 - DEVTRISKEL
 * Music Collection API
 * **********************************************************************
 */
package com.mg.mscollection.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mg.mscollection.util.DateUtils;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//@Getter
//@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

  private Status status;
  private T payload;
  private Object errors;

  // Getters & Setters
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public T getPayload() {
    return payload;
  }

  public Response<T> setPayload(T payload) {
    this.payload = payload;

    return this;
  }

  public Object getErrors() {
    return errors;
  }

  public Response<T> setErrors(Object errors) {
    this.errors = errors;

    return this;
  }

  // Other methods
  public static <T> Response<T> ok() {
    Response<T> response = new Response<>();
    response.setStatus(Status.OK);

    return response;
  }

  public static <T> Response<T> badRequest() {
    Response<T> response = new Response<>();
    response.setStatus(Status.BAD_REQUEST);

    return response;
  }

  public static <T> Response<T> validationException() {
    Response<T> response = new Response<>();
    response.setStatus(Status.VALIDATION_EXCEPTION);
  
    return response;
  }

  public static <T> Response<T> exception() {
    Response<T> response = new Response<>();
    response.setStatus(Status.EXCEPTION);

    return response;
  }
  
  public static <T> Response<T> notFound() {
    Response<T> response = new Response<>();
    response.setStatus(Status.NOT_FOUND);
    
    return response;
  }

  public void addErrorMsgToResponse(String errorMsg, Exception ex) {
    ResponseError error = new ResponseError();

    error.setDetails(errorMsg);
    error.setMessage(ex.getMessage());
    error.setTimestamp(DateUtils.today());

    setErrors(error);
  }

  public enum Status {
    OK, BAD_REQUEST, VALIDATION_EXCEPTION, EXCEPTION, NOT_FOUND
  }

}

