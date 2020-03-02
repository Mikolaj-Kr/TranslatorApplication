package com.MikolajKrawczak.TranslatorApp.api.translations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetectedLanguage {

    @JsonProperty("language")
    String language;
}
