package org.example.ngsign.usermanagement.exception;

public enum ErrorCodes {





  UTILISATEUR_NOT_FOUND(12000),
  UTILISATEUR_NOT_VALID(12001),
  UTILISATEUR_ALREADY_EXISTS(12002);



  private int code;

  ErrorCodes(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
