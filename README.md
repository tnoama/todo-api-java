# ToDo API in Java

This project is a simple ToDo API built with Java 17+ and Spring Boot. It provides endpoints for managing tasks, including creating, completing, and retrieving ToDos.

## Project Structure

```
todo-api-java
├── pom.xml
├── README.md
├── LLM_PROMPTS.md
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── todo
│   │                   ├── TodoApplication.java
│   │                   ├── model
│   │                   │   └── Todo.java
│   │                   ├── dto
│   │                   │   └── CreateTodoRequest.java
│   │                   ├── controller
│   │                   │   └── TodoController.java
│   │                   ├── service
│   │                   │   └── TodoService.java
│   │                   └── repo
│   │                       └── InMemoryTodoRepository.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── todo
│                       ├── controller
│                       │   └── TodoControllerTest.java
│                       └── service
│                           └── TodoServiceTest.java
```

## Endpoints

- **POST /api/todos**: Create a new task.  
  Request body: `{ "title": "...", "description": "..." }`

- **PATCH /api/todos/{id}/complete**: Mark a task as completed.

- **GET /api/todos**: Retrieve all tasks, sorted by status (open before completed) and creation time.

## Validation

- `title`: Required, 1–100 characters.
- `description`: Optional, up to 500 characters.
- Returns 400 with appropriate error messages for invalid input.

## Running the Application

To run the application, use the following command:

```
mvn spring-boot:run
```

## Testing

To run the tests, use the following command:

```
mvn test
```

## Example cURL Commands

### Create a Task

```
curl -X POST http://localhost:8080/api/todos \
  -H 'Content-Type: application/json' \
  -d '{"title":"Buy milk","description":"2%"}'
```

### Mark as Completed

```
curl -X PATCH http://localhost:8080/api/todos/1/complete
```

### Retrieve All Tasks

```
curl http://localhost:8080/api/todos
```

## Additional Information

Refer to `LLM_PROMPTS.md` for documentation of prompts used during development.