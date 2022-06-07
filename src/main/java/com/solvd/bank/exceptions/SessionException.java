package com.solvd.bank.exceptions;

import java.io.IOException;

public class SessionException extends RuntimeException {
  public SessionException(String message) {
    super(message);
  }
}
