# AGENTS.md - Order Service Development Guide

## Project Overview
**order-service** is a Spring Boot 4.0.5 microservice (Java 21) for handling e-commerce orders, part of a larger microservices ecosystem. This is a minimal REST API currently with health check capabilities.

## Build & Development Commands
- **Build**: `./mvnw clean package` (or `mvnw.cmd clean package` on Windows)
- **Run locally**: `./mvnw spring-boot:run`
- **Test**: `./mvnw test`
- **Quick compile**: `./mvnw compile`
- Maven wrapper is configured - use `./mvnw` instead of `mvn` command

## Project Structure & Patterns

### Package Organization
```
com.sampleapp.order/
├── OrderApplication.java          # @SpringBootApplication entry point
├── controller/
│   └── OrderController.java        # REST endpoints
└── resources/
    └── application.properties      # Configuration (app name, port)
```

### Naming Conventions
- **Package naming**: `com.sampleapp.order.*` - respect this namespace
- **REST endpoints**: Base path is `/api/orders` (defined in `@RequestMapping`)
- **Controllers**: Use `@RestController` + `@RequestMapping` pattern (see OrderController.java example)

### Key Dependencies & Versions
- **Spring Boot**: 4.0.5 (latest)
- **Java**: 21
- **Web Framework**: spring-boot-starter-web (included for REST endpoints)
- **Testing**: JUnit 5 with @SpringBootTest for integration tests

## Development Patterns

### Adding New REST Endpoints
1. Create methods in `OrderController` with `@GetMapping`/`@PostMapping`/etc.
2. Map to `/api/orders/*` paths
3. Return JSON-serializable objects (Map, domain objects, etc.)
4. Example health check pattern: returns `Map.of("status", "UP", "service", "order-service")`

### Adding Tests
- Place tests in `src/test/java/com/sampleapp/order/` mirroring source structure
- Use `@SpringBootTest` for integration tests (auto-wires Spring context)
- Follow existing OrderApplicationTests pattern

### Configuration
- Edit `src/main/resources/application.properties` for Spring Boot config
- Currently sets `spring.application.name=order-service` (required for service discovery in microservices setup)
- Server port: defaults to 8080 (can be set via `server.port` property)

## Integration Points
- **Part of microservices ecosystem**: Located in `microservices-ecommerce` directory
- **Service naming**: Explicitly named in properties for service-to-service communication
- **Health endpoint**: `/api/orders/health` provides liveness status for load balancers/orchestrators

## Critical Notes for Agents
1. **Minimal codebase**: Currently only has health check - grow conservatively following existing patterns
2. **Maven over Gradle**: Always use Maven commands via wrapper
3. **Spring Boot conventions**: Leverage auto-configuration; avoid manual bean definition unless necessary
4. **Microservice context**: Consider how changes affect inter-service communication and deployment
5. **No external DB configured yet**: Future additions (JPA, databases) should use Spring Data patterns

