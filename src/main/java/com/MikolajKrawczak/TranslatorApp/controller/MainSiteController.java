package com.MikolajKrawczak.TranslatorApp.controller;

import java.util.HashMap;
import java.util.Map;
import javax.naming.event.ObjectChangeListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainSiteController {

  @RequestMapping("/translator-main")
  public ModelAndView getMainSite(){
    Map<String, Object> params = new HashMap<>();
  return new ModelAndView("")
  }

}
