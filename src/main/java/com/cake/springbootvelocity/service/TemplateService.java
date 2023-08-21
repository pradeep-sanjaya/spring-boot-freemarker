package com.cake.springbootvelocity.service;

import freemarker.template.TemplateException;

import java.io.IOException;

public interface TemplateService {
    public String process() throws IOException, TemplateException;
}
