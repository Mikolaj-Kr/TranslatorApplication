package com.MikolajKrawczak.TranslatorApp.api;

import com.MikolajKrawczak.TranslatorApp.api.translations.DetectedLanguage;
import com.MikolajKrawczak.TranslatorApp.api.translations.Translations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationsApi {

    @JsonProperty("detectedLanguage")
    DetectedLanguage detectedLanguage;

    @JsonProperty("translations")
    Translations translations;
}
