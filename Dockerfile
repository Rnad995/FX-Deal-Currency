# Use a base image
FROM openjdk:11

# Set the working directory in the container
WORKDIR /fxdeal-project

# Copy the application files into the container
COPY . /fxdeal-project

# Install dependencies if needed
# RUN command_to_install_dependencies

# Set environment variables
ENV VARIABLE_NAME=value

# Expose a port if needed
# EXPOSE port_number

# Run a command to start the application
CMD ["java", "-jar", "fxdeal-project.jar"]
