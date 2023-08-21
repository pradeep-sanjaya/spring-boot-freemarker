package com.cake.springbootvelocity.service.impl;

import com.cake.springbootvelocity.service.TemplateService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TemplateServiceImpl implements TemplateService {
    @Override
    public String process() throws IOException, TemplateException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);

        // Create a data model (context)
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name", "John");

        // Create a FreeMarker template loader for string templates
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("welcome", "Hello ${name}! Welcome to MadMobile Loyalty.");
        cfg.setTemplateLoader(stringTemplateLoader);

        // Load the template
        Template template = cfg.getTemplate("welcome");

        // Process the template
        StringWriter writer = new StringWriter();
        template.process(dataModel, writer);

        // Return the processed template as a String
        return writer.toString();
    }
}
