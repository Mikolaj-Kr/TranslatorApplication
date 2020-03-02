package com.MikolajKrawczak.TranslatorApp.api.supportedLanguagesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Language {

  @JsonProperty("name")
  String name;

  @JsonProperty("nativeName")
  String nativeName;

  @JsonProperty("dir")
  String dir;

}
