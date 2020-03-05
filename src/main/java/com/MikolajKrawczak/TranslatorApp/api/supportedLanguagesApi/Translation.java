package com.MikolajKrawczak.TranslatorApp.api.supportedLanguagesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.apache.commons.codec.language.bm.Lang;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Translation {

    @JsonProperty("ru")
    private Language russian;

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

    @JsonProperty("pl")
    private Language polish;
}

