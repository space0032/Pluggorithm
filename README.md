# Pluggorithm

A fully pluggable algorithmic SDK for Java that enables developers to build workflow-based pipelines of interchangeable algorithms.

## Features

- **Pluggable Architecture**: Dynamically add custom algorithms and use predefined ones
- **Fluent API**: Build pipelines using an intuitive, chainable builder pattern
- **Type Safety**: Generic type support for input and output types
- **Pipeline Execution**: Chain multiple algorithms in sequence
- **ServiceLoader Support**: Load algorithms dynamically at runtime
- **Algorithm Registry**: Register and retrieve algorithms by name
- **Extensible**: Easily create custom algorithms by implementing the `BaseAlgorithm` interface

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Installation

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.pluggorithm</groupId>
    <artifactId>pluggorithm</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Building from Source

```bash
git clone https://github.com/space0032/Pluggorithm.git
cd Pluggorithm
mvn clean install
```

## Quick Start

### Basic Example

```java
import io.pluggorithm.core.*;
import io.pluggorithm.algorithms.*;
import java.util.*;

public class BasicExample {
    public static void main(String[] args) throws Exception {
        // Create a pipeline
        AlgorithmPipeline pipeline = PipelineBuilder.create()
            .addAlgorithm(new SortingAlgorithm())
            .enableLogging()
            .build();
        
        // Execute
        List<Integer> input = Arrays.asList(5, 2, 8, 1, 9);
        List<Integer> result = pipeline.execute(input);
        
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);
    }
}
```

### Using Filter and Transform

```java
import io.pluggorithm.core.*;
import io.pluggorithm.algorithms.*;
import java.util.*;

public class AdvancedExample {
    public static void main(String[] args) throws Exception {
        // Create a filter algorithm
        FilterAlgorithm<Integer> filter = new FilterAlgorithm<>();
        Map<String, Object> filterConfig = new HashMap<>();
        filterConfig.put("predicate", (Predicate<Integer>) x -> x > 5);
        
        // Create a transform algorithm
        TransformAlgorithm<Integer, String> transform = new TransformAlgorithm<>();
        Map<String, Object> transformConfig = new HashMap<>();
        transformConfig.put("transformer", (Function<Integer, String>) x -> "Number: " + x);
        
        // Build pipeline
        AlgorithmPipeline pipeline = PipelineBuilder.create()
            .addAlgorithm(new SortingAlgorithm())
            .addAlgorithm(filter, filterConfig)
            .addAlgorithm(transform, transformConfig)
            .enableLogging()
            .build();
        
        List<Integer> input = Arrays.asList(5, 2, 8, 1, 9, 12, 3);
        List<String> result = pipeline.execute(input);
        
        System.out.println("Result: " + result);
    }
}
```

## Creating Custom Algorithms

Implement the `BaseAlgorithm` interface:

```java
package com.example;

import io.pluggorithm.core.BaseAlgorithm;
import java.util.Map;

public class MyCustomAlgorithm implements BaseAlgorithm<String, String> {
    private String prefix = "";
    
    @Override
    public void configure(Map<String, Object> parameters) {
        prefix = (String) parameters.getOrDefault("prefix", "");
    }
    
    @Override
    public String execute(String input) {
        return prefix + input;
    }
    
    @Override
    public String getDescription() {
        return "Adds a prefix to the input string";
    }
}
```

## Predefined Algorithms

### SortingAlgorithm

Sorts a list of integers in ascending or descending order.

**Configuration:**
- `ascending` (boolean): Sort in ascending order (default: true)

### FilterAlgorithm

Filters elements from a list based on a predicate.

**Configuration:**
- `predicate` (Predicate<T>): Filter condition

### TransformAlgorithm

Transforms elements from one type to another using a function.

**Configuration:**
- `transformer` (Function<I, O>): Transformation function

## API Documentation

### Core Classes

#### BaseAlgorithm<I, O>

Base interface for all algorithms.

**Methods:**
- `void configure(Map<String, Object> parameters)`: Configure the algorithm
- `O execute(I input)`: Execute the algorithm
- `String getName()`: Get algorithm name
- `String getDescription()`: Get algorithm description

#### AlgorithmPipeline

Pipeline for executing a sequence of algorithms.

**Methods:**
- `AlgorithmPipeline addAlgorithm(BaseAlgorithm<?, ?> algorithm)`: Add an algorithm to the pipeline
- `void setLogging(boolean enable)`: Enable/disable logging
- `<T> T execute(Object input)`: Execute the pipeline
- `List<BaseAlgorithm<?, ?>> getAlgorithms()`: Get all algorithms in the pipeline

#### PipelineBuilder

Fluent builder for creating algorithm pipelines.

**Methods:**
- `static PipelineBuilder create()`: Create a new builder
- `PipelineBuilder addAlgorithm(BaseAlgorithm<?, ?> algorithm)`: Add an algorithm
- `PipelineBuilder addAlgorithm(BaseAlgorithm<?, ?> algorithm, Map<String, Object> config)`: Add and configure an algorithm
- `PipelineBuilder enableLogging()`: Enable logging
- `AlgorithmPipeline build()`: Build the pipeline

### Plugin System

#### AlgorithmPluginLoader

Dynamically loads algorithm plugins using Java ServiceLoader.

**Methods:**
- `static List<BaseAlgorithm<?, ?>> loadPlugins()`: Load all available plugins

#### AlgorithmRegistry

Registry for managing available algorithms.

**Methods:**
- `static void register(String name, BaseAlgorithm<?, ?> algorithm)`: Register an algorithm
- `static Optional<BaseAlgorithm<?, ?>> get(String name)`: Get an algorithm by name
- `static Map<String, BaseAlgorithm<?, ?>> getAll()`: Get all registered algorithms

## Running Tests

```bash
mvn test
```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Guidelines

- Follow Java coding conventions
- Add unit tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

Antariksh Mankar

## Project Links

- [GitHub Repository](https://github.com/space0032/Pluggorithm)
- [Issue Tracker](https://github.com/space0032/Pluggorithm/issues)

## Changelog

### Version 1.0.0
- Initial release
- Core pipeline functionality
- Predefined algorithms (Sort, Filter, Transform)
- Plugin system with ServiceLoader
- Algorithm registry
- Comprehensive test suite
