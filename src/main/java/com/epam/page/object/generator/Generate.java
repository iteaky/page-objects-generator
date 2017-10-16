package com.epam.page.object.generator;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Roman_Iovlev on 10/16/2017.
 */
public class Generate {

    public static void main(String[] args) throws ParseException, IOException, URISyntaxException {
        List<String> urls = asList(
            "https://www.w3schools.com/html/html_forms.asp",
            "https://www.w3schools.com/css/default.asp",
            "https://www.w3schools.com/html/html_form_input_types.asp");

        new PageObjectsGenerator(
                "src/test/resources/valid.json",
                urls,
                "D:/Work/Projects/Java/JDI Generator/page-objects-generator-tests/src/main/java/",
                "w3c.test")
                .generatePageObjects();
    }
}
