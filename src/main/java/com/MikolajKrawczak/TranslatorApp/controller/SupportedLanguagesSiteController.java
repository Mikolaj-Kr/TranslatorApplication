package com.MikolajKrawczak.TranslatorApp.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupportedLanguagesSiteController {

  @RequestMapping("/translator-supported-languages")
  public ModelAndView getMainSite(){
    Map<String, Object> params = new HashMap<>();
    return new ModelAndView("supported-languages-site", params);
  }

}
