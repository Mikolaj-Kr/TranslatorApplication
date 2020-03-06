package com.MikolajKrawczak.TranslatorApp.service;

import com.MikolajKrawczak.TranslatorApp.api.TranslationsApi;
import com.MikolajKrawczak.TranslatorApp.parser.TranslationParser;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.codec.language.bm.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TranslationsService {

    @Autowired
    TranslationParser translationParser;

    @Autowired
    LanguagesService languagesService;

    public TranslationsApi getTranslations(String text, String to, String from) throws IOException, UnirestException {
        return translationParser.parseTranslation(text, languageToShortcut(to), languageToShortcut(from));
    }

    private String languageToShortcut(String language) {
        switch (language) {
            case "Czech":
                return "cs";
            case "German":
                return "de";
            case "English":
                return "en";
            case "Spanish":
                return "es";
            case "French":
                return "fr";
            case "Polish":
                return "pl";
            case "Russian":
                return "ru";
            default:
                return "noInfo";
        }
    }
}
