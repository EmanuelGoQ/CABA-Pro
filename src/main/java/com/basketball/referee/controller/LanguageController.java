package com.basketball.referee.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Controller
public class LanguageController {

    private final LocaleResolver localeResolver;

    public LanguageController(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @PostMapping("/setLanguage")
    public String setLanguage(@RequestParam("lang") String lang, HttpServletResponse response) {
        localeResolver.setLocale(null, response, Locale.forLanguageTag(lang));
        return "redirect:/login?lang=" + lang;
    }
}
