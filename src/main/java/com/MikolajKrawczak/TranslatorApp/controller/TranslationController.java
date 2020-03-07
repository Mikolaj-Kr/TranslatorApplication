package com.MikolajKrawczak.TranslatorApp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.MikolajKrawczak.TranslatorApp.service.LanguagesService;
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
public class TranslationController {

    @Autowired
    TranslationsService translationsService;

    @Autowired
    LanguagesService languagesService;

    @RequestMapping("/translator-main")
    public ModelAndView getMainSite(@RequestParam(value = "text", required = false) String text, @RequestParam(value = "from", required = false) String from, @RequestParam(value = "to", required = false) String to, @RequestParam(value = "language", required = false) String siteLanguage, HttpServletResponse response, HttpServletRequest request) throws IOException, UnirestException {
        Map<String, Object> params = new HashMap<>();

        if (siteLanguage == null){
            siteLanguage = "en";
        }
        params.put("languages", languagesService.getSupportedLanguages());
        params.put("from", from);
        params.put("to", to);
        params.put("textToTranslate", text);
        params.put("site", "main");
        params.put("siteLanguage", siteLanguage);

        request.getSession().setAttribute("siteLanguage", siteLanguage);

        if (to != null && to.equals("Choose") && siteLanguage.equals("en")){
            params.put("translatedText", "Select language to translate");
            text = null;
        } else if (to != null && to.equals("Wybierz") && siteLanguage.equals("pl")) {
            params.put("translatedText", "Wybierz język na jaki przetłumaczyć tekst");
            text = null;
        }

        if (text != null && !to.equals("Choose")) {
          params.put("translatedText", translationsService.getTranslations(text, to, from).getTranslations().getText());
        }

        if(siteLanguage.equals("pl")) {
            return new ModelAndView("translator-pl", params);
        } else {
            return new ModelAndView("translator-en",params);
        }
    }

    @PostMapping("/translator-main")
    public ResponseEntity<String> translateText(@RequestParam(value = "inputText") String inputText, @RequestParam(value = "from") String from, @RequestParam(value = "to") String to, HttpServletResponse response, HttpServletRequest request) throws IOException, UnirestException {
        response.sendRedirect("/translator-main?text=" + inputText + "&from=" + from +"&to=" + to + "&language=" + request.getSession().getAttribute("siteLanguage"));
        return new ResponseEntity<>(inputText, HttpStatus.OK);
    }

}
