AI Prompts Transcript - Assignment 3
Model Used: Gemini 3 Flash

User: Saleh A.

Date: February 20, 2026

Prompt 1: Initial Brainstorming
User: "I need to refactor my Assignment 2 (procedural CSV processing) into an Object-Oriented design for Assignment 3. How should I break this down into classes?"

AI Response Excerpt:
The AI suggested a "Model-Service-Orchestrator" pattern, recommending the following classes:

Product: To represent the data entity.

CSVService: To handle File I/O.

ProductTransformer: To encapsulate business logic.

ProductManager: To act as the driver/entry point.

Prompt 2: Deep Dive into Class Responsibilities
User:
"Give an indepth, step by step demo of how these classes interact."

AI Response Excerpt:
The AI provided a breakdown of how the ProductManager uses the CSVService to load data into a List<Product>, then passes that list to the ProductTransformer for modification, and finally uses the service again to save the results. It emphasized Encapsulation by using private fields and getters/setters in the Product class.

Prompt 3: Specific File Implementation
User:
"This is too vague be specific as to what classes need to be made and where."

AI Response Excerpt:
The AI provided the exact Java code for four specific files:

Product.java

ProductTransformer.java

CSVService.java

ProductManager.java
It also included Javadoc templates and explained how the toCSVRow() method helps maintain the CSV format during output.

Prompt 4: File Structure and Paths
User:
"Explain the file paths where and when to create/name files."

AI Response Excerpt:
The AI provided a visual tree diagram of the project root. It clarified that:

Source files must follow the org/howard/edu/lsp/assignment3/ directory nesting.

Documentation goes in a doc/ sub-package.

The data/ folder must be at the project root, outside of src/, to satisfy relative path requirements.

Prompt 5: Final Review
User:
"Yes [Generate the AI transcript]."

AI Response Excerpt:
The AI generated this Markdown file summarizing the prompts used to reach the final OO design.

Reflection on AI Usage
The AI was used to brainstorm the architectural shift from procedural to OO. It helped identify how to separate concerns (Input vs. Logic vs. Storage) and provided a template for Javadoc documentation to ensure the code met lecture standards.