# quic-http3-springboot
This project demonstrates the integration of QUIC and HTTP/3 protocols within a Spring Boot application.

## Project Structure
**http3-client:** Contains the client-side implementation for HTTP/3 communication.
**netty-server:** Hosts the server-side code utilizing Netty to handle QUIC and HTTP/3 protocols.

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Gradle build tool

## Getting Started
Clone the Repository:
```bash
git clone https://github.com/pranonrahman/quic-http3-springboot.git
cd quic-http3-springboot
```

**Build the Project:** Execute the following command to build both the client and server modules:

```bash
gradle build
```

**Run the Server:** Navigate to the netty-server directory and start the server:

```bash
cd netty-server
java -jar build/libs/netty-server.jar
```

**Run the Client:** In a separate terminal, navigate to the http3-client directory and run the client:

```bash
cd http3-client
java -jar build/libs/http3-client.jar
```

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your enhancements or bug fixes.

License
This project is licensed under the MIT License.
