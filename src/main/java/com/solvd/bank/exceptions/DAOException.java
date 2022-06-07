package com.solvd.bank.exceptions;

import java.sql.SQLException;

public class DAOException extends RuntimeException {
  public DAOException(String message) {
    super(message);
  }
}
