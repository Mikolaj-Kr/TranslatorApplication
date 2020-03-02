package com.MikolajKrawczak.TranslatorApp.api;

import com.MikolajKrawczak.TranslatorApp.api.supportedLanguagesApi.Translation;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguagesApi {

  @JsonProperty("translation")
  private Translation languages;

}
