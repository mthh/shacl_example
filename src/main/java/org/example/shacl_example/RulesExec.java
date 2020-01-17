package org.example.shacl_example;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.topbraid.jenax.util.JenaUtil;
import org.topbraid.shacl.rules.RuleUtil;

import java.io.StringWriter;

public class RulesExec {
    private static final Logger logger = LoggerFactory.getLogger(Validation.class);

    public static void main(String[] args) {
        Model dataModel = JenaUtil.createDefaultModel();
        dataModel.read(Validation.class.getResourceAsStream("/rectangle.ttl"), null, FileUtils.langTurtle);

        Model shapeModel  = JenaUtil.createDefaultModel();
        shapeModel.read(Validation.class.getResourceAsStream("/rectangleShape.ttl"), null, FileUtils.langTurtle);

        Model newTriples = JenaUtil.createDefaultModel();
        Model results = RuleUtil.executeRules(dataModel, shapeModel, newTriples, null);
        newTriples.write(System.out, FileUtils.langTurtle);
    }
}