package com.MikolajKrawczak.TranslatorApp.parser;


import com.MikolajKrawczak.TranslatorApp.api.TranslationsApi;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TranslationParser {

    private ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public TranslationsApi parseTranslation(String textToTranslate, String translationTo, String translationFrom) throws IOException, UnirestException {


        String jsonInputString = "[\n{\"Text\":\"" + textToTranslate + "\"}\n]";
        HttpResponse<String> response;

        if (translationFrom.equals("noInfo")) {
            response = Unirest.post("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=" + translationTo + "subscriptionKey")
                    .header("Content-type", "application/json")
                    .body(jsonInputString)
                    .asString();
        } else {
            response = Unirest.post("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=" + translationTo + "&from=" + translationFrom + "subscriptionKey")
                    .header("Content-type", "application/json")
                    .body(jsonInputString)
                    .asString();
        }

        List<String> array = new ArrayList<String>();

        List<String> responseArray = List.of(response.getBody());


        String responseBody = String.join("", responseArray).replaceAll("]","").replaceAll("\\[","");


        logger.info(responseBody);
        return objectMapper.readValue(responseBody, TranslationsApi.class);
    }


}
