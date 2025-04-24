import os
from jinja2 import Environment, FileSystemLoader
from besser.BUML.metamodel.structural import DomainModel
from besser.generators import GeneratorInterface

class CodeGenerator(GeneratorInterface):

    def __init__(self, model: DomainModel, output_dir: str = None):
        super().__init__(model, output_dir)

    def generate(self, language='java'):
        if language == 'java':
            self.generate_language(input='java_template.py.j2', output='code.java')
        elif language == 'c#':
            self.generate_language(input='c#_template.py.j2', output='code.cs')

    def generate_language(self, input, output):
        
        output_file_path = self.build_generation_path(file_name=output)        

        templates_path = os.path.join(os.path.dirname(
            os.path.abspath(__file__)), "templates")
        env = Environment(loader=FileSystemLoader(
            templates_path), trim_blocks=True, lstrip_blocks=True, extensions=['jinja2.ext.do'])
        
        template_input = env.get_template(input)
        
        with open(output_file_path, mode="w") as f:
            generated_code = template_input.render(model=self.model)
            f.write(generated_code)
            print("Code generated in the location: " + output_file_path)