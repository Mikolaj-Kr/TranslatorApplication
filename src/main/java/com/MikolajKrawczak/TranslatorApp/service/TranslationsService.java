package com.MikolajKrawczak.TranslatorApp.service;

import com.MikolajKrawczak.TranslatorApp.api.TranslationsApi;
import com.MikolajKrawczak.TranslatorApp.parser.TranslationParser;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TranslationsService {

    @Autowired
    TranslationParser translationParser;

    public TranslationsApi getTranslationsWithDetectedLanguage(String text, String to) throws IOException, UnirestException {
        return translationParser.parseTranslation(text, to, "noInfo");
    }

    public TranslationsApi getTranslations(String text, String to, String from) throws IOException, UnirestException{
        return translationParser.parseTranslation(text, to, from);
    }
}
