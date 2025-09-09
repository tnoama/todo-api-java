# This file documents the prompts used during development, including what was asked and any changes made.

1. Prompt: "can you build for me the structure of this project including maven and all of the folders and files, but leave the all empty so i could do it myself?"

   - Response: Provided a basic structure and endpoints for the ToDo API.

2. Prompt: "can you help me apply maven to this project and make the pom.xml file"

   - Response: Helped with those assignments.

3. Prompt: "what is the main purpose of each file?"

   - Response:
     main/java/com/example/todo/

TodoApplication.java: Starts the Spring Boot application.
model/Todo.java: Represents the ToDo data structure.
dto/CreateTodoRequest.java: DTO for creating a new ToDo, includes validation.
controller/TodoController.java: Handles HTTP requests for ToDo operations.
service/TodoService.java: Contains business logic for ToDo management.
repo/InMemoryTodoRepository.java: Manages in-memory storage and retrieval of ToDos.

4. Prompt: "{
   "timestamp": "2025-09-09T08:58:57.482+00:00",
   "status": 400,
   "error": "Bad Request",
   "path": "/todos"
   }

This is what i got when i inserted an empty title. i want the error to have a message that tells me i need to have at least 1 character and max 100"

- Response: You need to get an exception handler file to handle the errors different from springboot default.

5. Prompt: "What validation should I implement for the ToDo creation request?"
   - Response: Advised on using @NotBlank and @Size annotations for validating title and description fields.
