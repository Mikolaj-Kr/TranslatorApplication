package com.MikolajKrawczak.TranslatorApp.controller;

import java.util.HashMap;
import java.util.Map;

import com.MikolajKrawczak.TranslatorApp.service.LanguagesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupportedLanguagesSiteController {

  @Autowired
  LanguagesService languagesService;

  @RequestMapping("/translator-supported-languages")
  public ModelAndView getMainSite() throws JsonProcessingException, UnirestException {
    Map<String, Object> params = new HashMap<>();
    params.put("languages", languagesService.getSupportedLanguages());

    return new ModelAndView("supported-languages-site", params);
  }

}
