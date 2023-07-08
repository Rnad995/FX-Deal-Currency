# Define the default target
.DEFAULT_GOAL := help

# Define variables
PROJECT_NAME := fxdeal
JAVA_FILES := $(shell find src/main/java -name "*.java")
JAR_FILE := target/fxdeal.jar

# Define targets and commands
.PHONY: clean build run test help

clean:
	@echo "Cleaning build artifacts..."
	@mvn clean

build:
	@echo "Building the project..."
	@mvn package

run:
	@echo "Running the application..."
	@java -jar fxdeal-0.0.1-snapshot.jar

test:
	@echo "Running tests..."
	@mvn test

help:
	@echo "Available targets:"
	@echo "  clean  - Clean build artifacts"
	@echo "  build  - Build the project"
	@echo "  run    - Run the application"
	@echo "  test   - Run tests"
	@echo "  help   - Display this help message"
