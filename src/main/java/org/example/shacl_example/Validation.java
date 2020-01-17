package org.example.shacl_example;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.topbraid.jenax.util.JenaUtil;
import org.topbraid.shacl.validation.ValidationUtil;
import org.topbraid.shacl.vocabulary.SH;

import java.io.StringWriter;

public class Validation {
    private static final Logger logger = LoggerFactory.getLogger(Validation.class);

    public static void main(String[] args) {
        Model dataModel = JenaUtil.createDefaultModel();
        dataModel.read(Validation.class.getResourceAsStream("/book.ttl"), null, FileUtils.langTurtle);

        Model shapeModel  = JenaUtil.createDefaultModel();
        shapeModel.read(Validation.class.getResourceAsStream("/bookShape.ttl"), null, FileUtils.langTurtle);

        Resource reportResource = ValidationUtil.validateModel(dataModel, shapeModel, true);
        boolean conforms = reportResource.getProperty(SH.conforms).getBoolean();
        logger.warn("Conforms = " + conforms);
        if(!conforms){
            StringWriter stringWriter = new StringWriter();
            RDFDataMgr.write(stringWriter, reportResource.getModel(), RDFFormat.TTL);
            System.out.println(stringWriter.toString());
        } else {
            System.out.println("CONFORMS");
        }
    }
}