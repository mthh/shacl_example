### shacl_example

Code & resources to illustrate [presentation on SHACL](https://mthh.github.io/shacl_intro_20200117/).  
Project use [maven](https://mvnrepository.com/) for dependencies management.

Fetching dependencies:

```bash
mvn install
```


Running the "validation" example  
*(will print the validation report)*

```bash
mvn exec:java -Dexec.arguments="validation"
```


Running the "rules" example  
*(will print the inferred triples)*

```bash
mvn exec:java -Dexec.arguments="rules"
```
