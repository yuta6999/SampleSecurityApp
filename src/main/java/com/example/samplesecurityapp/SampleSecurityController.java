//▼リスト7-35
package com.example.samplesecurityapp;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleSecurityController {
  
  @RequestMapping("/")
  @PreAuthorize("permitAll")
  public ModelAndView index(ModelAndView mav) {
    mav.setViewName("index");
    mav.addObject("title", "Index page");
    mav.addObject("msg", "This is top page.");
    return mav;
  }

  @RequestMapping("/secret")
  @PreAuthorize("isAuthenticated()")
  public ModelAndView secret(ModelAndView mav) {
    mav.setViewName("Secret");
    mav.addObject("title", "Secret page");
    mav.addObject("msg", "This is secret page.");
    return mav;
  }

  @RequestMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public ModelAndView admin(ModelAndView mav) {
    mav.setViewName("index");
    mav.addObject("title", "Admin page");
    mav.addObject("msg", "This is only access ADMIN!");
    return mav;
  }
  
//  ▼リスト7-38
  @RequestMapping("/login")
  @PreAuthorize("permitAll")
  public ModelAndView login(ModelAndView mav,
      @RequestParam(value="error", required=false)String error) {
    mav.setViewName("login");
    System.out.println(error);
    if (error != null) {
      mav.addObject("msg", "ログインできませんでした。");
    } else {
      mav.addObject("msg", "ユーザー名とパスワードを入力：");
    }
    return mav;
  }

}