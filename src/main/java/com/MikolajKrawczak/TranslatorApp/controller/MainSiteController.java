package com.MikolajKrawczak.TranslatorApp.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.MikolajKrawczak.TranslatorApp.api.TranslationsApi;
import com.MikolajKrawczak.TranslatorApp.parser.TranslationParser;
import com.MikolajKrawczak.TranslatorApp.service.TranslationsService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainSiteController {

    @Autowired
    TranslationsService translationsService;

    @RequestMapping("/translator-main")
    public ModelAndView getMainSite(@RequestParam(value = "text", required = false) String text, @RequestParam(value = "from", required = false) String from, @RequestParam(value = "to", required = false) String to) throws IOException, UnirestException {
        Map<String, Object> params = new HashMap<>();


        if (text != null) {
          params.put("translatedText", translationsService.getTranslationsWithDetectedLanguage(text, "pl").getTranslations().getText());
        }
        return new ModelAndView("main-site", params);
    }

    @PostMapping("/translator-main")
    public ResponseEntity<String> translateText(@RequestParam(value = "inputText") String inputText, HttpServletResponse response) throws IOException, UnirestException {


        response.sendRedirect("/translator-main?text=" + inputText);
        return new ResponseEntity<>(inputText, HttpStatus.OK);
    }

}
