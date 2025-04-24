Run main.py file to generate C# and Java code from BUML model definition.

main.py calls generator.py in the following manner:

- generator.generate('java')
- generator.generate('c#')

Based on desired output language, appropriate jinja template is used.
Generated code is saved to /output directory.