package com.backend.ecomm.product.domain.vo;

import com.backend.ecomm.shared.error.domain.NotAColorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record ProductColor(String value) {

  public ProductColor {
    Pattern colorPattern = Pattern.compile("#([0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8})");
    Matcher matcher = colorPattern.matcher(value);
    boolean isColor = matcher.matches();
    if(!isColor) {
      throw new NotAColorException(value, "Invalid color");
    }
  }
}
