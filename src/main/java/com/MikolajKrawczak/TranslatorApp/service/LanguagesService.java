package com.MikolajKrawczak.TranslatorApp.service;

import com.MikolajKrawczak.TranslatorApp.api.LanguagesApi;
import com.MikolajKrawczak.TranslatorApp.api.supportedLanguagesApi.Language;
import com.MikolajKrawczak.TranslatorApp.parser.LanguageParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguagesService {

    @Autowired
    LanguageParser languageParser;

    public List<Language> getSupportedLanguages() throws JsonProcessingException, UnirestException {
        LanguagesApi languagesApi = languageParser.parseLanguages();
        List<Language> languages = new ArrayList<>();

        languages.add(languagesApi.getLanguages().getCzech());
        languages.add(languagesApi.getLanguages().getEnglish());
        languages.add(languagesApi.getLanguages().getFrench());
        languages.add(languagesApi.getLanguages().getGerman());
        languages.add(languagesApi.getLanguages().getPolish());
        languages.add(languagesApi.getLanguages().getSpanish());
        languages.add(languagesApi.getLanguages().getRussian());

        return languages;
    }
}
