package com.hainet.doma.spring.boot.sample.config.annotation;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@AnnotateWith(annotations = {
        @Annotation(target = AnnotationTarget.CLASS, type = Repository.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class),
        @Annotation(target = AnnotationTarget.CONSTRUCTOR_PARAMETER, type = DataSource1.class)})
public @interface ConfigAutowireableDataSource1 {
}
