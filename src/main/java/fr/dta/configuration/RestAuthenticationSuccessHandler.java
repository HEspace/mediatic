package fr.dta.configuration;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class RestAuthenticationSuccessHandler 
extends SimpleUrlAuthenticationSuccessHandler {
 
 
 @Override
 public void onAuthenticationSuccess(HttpServletRequest request, 
  HttpServletResponse response, Authentication authentication)
 throws ServletException, IOException {
  System.out.println("Sucess");
  System.out.println(authentication.getName()+authentication.getCredentials()+authentication.toString()+authentication.getPrincipal());
 }
}