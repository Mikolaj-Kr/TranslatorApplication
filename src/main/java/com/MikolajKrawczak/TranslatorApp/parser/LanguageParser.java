package com.MikolajKrawczak.TranslatorApp.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;


@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LanguageParser {

  private ObjectMapper objectMapper = new ObjectMapper();
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public

  HttpResponse<String> response = Unirest.get(String.format("https://api.cognitive.microsofttranslator.com/languages?api-version=3.0")).asString();



}
