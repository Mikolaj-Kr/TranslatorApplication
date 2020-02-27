package com.MikolajKrawczak.TranslatorApp.api.supportedLanguagesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Translation {

  @JsonProperty("cs")
  private Language czech;

  @JsonProperty("de")
  private Language german;

  @JsonProperty("en")
  private Language english;

  @JsonProperty("es")
  private Language spanish;

  @JsonProperty("fr")
  private Language french;

}

