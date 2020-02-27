package com.MikolajKrawczak.TranslatorApp.api.supportedLanguagesApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Language {

  @JsonProperty
  String name;

  @JsonProperty
  String nativeName;

  @JsonProperty
  String dir;

}
