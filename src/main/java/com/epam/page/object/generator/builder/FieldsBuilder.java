package com.epam.page.object.generator.builder;

import com.epam.page.object.generator.model.SearchRule;
import com.squareup.javapoet.FieldSpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FieldsBuilder implements IFieldsBuilder {

    private Class elementClass;
	private Class annotationClass;
    FieldAnnotationFactory fieldAnnotationFactory;

    public FieldsBuilder(Class elementClass, Class annotationClass, FieldAnnotationFactory fieldAnnotationFactory) {
        this.elementClass = elementClass;
		this.annotationClass = annotationClass;
        this.fieldAnnotationFactory = fieldAnnotationFactory;
    }

    @Override
    public List<FieldSpec> buildField(SearchRule searchRule, String url ) throws IOException {
        fieldAnnotationFactory.setAnnotationClass(annotationClass);


        List<FieldSpec> abstractFields = new ArrayList<>();
        List<String> elementsRequiredValues = searchRule.getRequiredValueFromFoundElement(url);

        for (String elementsRequiredValue : elementsRequiredValues) {
            FieldSpecFactory fieldSpecFactory = new FieldSpecFactory(elementClass,elementsRequiredValue);
            abstractFields.add(fieldSpecFactory.build(fieldAnnotationFactory.buildAnnotation(searchRule,elementsRequiredValue,url)));

        }

        return abstractFields;
    }

    public Class getElementClass() {
        return elementClass;
    }

    public Class getAnnotationClass() {
        return annotationClass;
    }

}