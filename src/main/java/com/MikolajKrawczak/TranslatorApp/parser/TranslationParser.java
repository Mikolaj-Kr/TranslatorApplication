package com.MikolajKrawczak.TranslatorApp.parser;


import com.MikolajKrawczak.TranslatorApp.api.TranslationsApi;
import com.MikolajKrawczak.TranslatorApp.service.ApiKeyReader;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import java.io.IOException;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TranslationParser {

    private ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApiKeyReader apiKeyReader;


    public TranslationsApi parseTranslation(String textToTranslate, String translationTo, String translationFrom) throws IOException, UnirestException {


        String jsonInputString = "[\n{\"Text\":\"" + textToTranslate + "\"}\n]";
        HttpResponse<String> response;

        if (translationFrom.equals("noInfo")) {
            response = Unirest.post("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=" + translationTo + "&Subscription-Key=" + apiKeyReader.readApiKey())
                    .header("Content-type", "application/json")
                    .body(jsonInputString)
                    .asString();
        } else {
            response = Unirest.post("https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=" + translationTo + "&from=" + translationFrom + "&Subscription-Key=" + apiKeyReader.readApiKey())
                    .header("Content-type", "application/json")
                    .body(jsonInputString)
                    .asString();
        }

        String responseBody = response.getBody().replaceAll("\\[", "").replaceAll("]", "");

        logger.info("translated text from " + translationFrom + " to " + translationTo);
        logger.info(responseBody);
        return objectMapper.readValue(responseBody, TranslationsApi.class);
    }


}
