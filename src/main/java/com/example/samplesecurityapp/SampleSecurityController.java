//▼リスト7-24
package com.example.samplesecurityapp;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleSecurityController {
  
  @RequestMapping("/")
  public ModelAndView index(ModelAndView mav) {
    mav.setViewName("index");
    mav.addObject("title", "Index page");
    mav.addObject("msg", "This is top page.");
    return mav;
  }

  @RequestMapping("/secret")
  public ModelAndView secret(ModelAndView mav, HttpServletRequest request) {
    String user = request.getRemoteUser();
    String msg = "This is secret page. [login by \"" + user + "\"]";
    mav.setViewName("Secret");
    mav.addObject("title", "Secret page");
    mav.addObject("msg", msg);
    return mav;
  }
  
//  ▼リスト7-33
  @RequestMapping("/admin")
  public ModelAndView admin(ModelAndView mav) {
    mav.setViewName("index");
    mav.addObject("title", "Admin page");
    mav.addObject("msg", "This is only access ADMIN!");
    return mav;
  }
}