package com.MikolajKrawczak.TranslatorApp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

  @RequestMapping("/translator-main")
  public ModelAndView getMainSite(@RequestParam(value = "text", required = false) String text){
    Map<String, Object> params = new HashMap<>();
    params.put("translatedText", text);
  return new ModelAndView("main-site", params);
  }

  @PostMapping("/translator-main")
  public ResponseEntity<String> translateText(@RequestParam(value = "inputText") String inputText, HttpServletResponse response) throws IOException {
    response.sendRedirect("/translator-main?text=" + inputText);
    return new ResponseEntity<>(inputText, HttpStatus.OK);
  }

}
