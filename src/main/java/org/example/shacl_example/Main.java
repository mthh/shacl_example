package org.example.shacl_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static void exit_err(String message) {
        System.out.println(message);
        System.exit(1);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            exit_err("\nNo mode provided (should be \"validation\" or \"rules\").\n");
        } else if (args.length > 1) {
            exit_err("\nToo many arguments provided.\n");
        } else if (args[0].equals("validation")) {
            Validation.main(null);
        } else if (args[0].equals("rules")) {
            RulesExec.main(null);
        }
    }
}