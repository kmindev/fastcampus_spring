package org.example;

import org.example.calculate.Calculator;
import org.example.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * step1 - 사용자 요청을 메인 Thread 가 처리하도록 한다.
 * step2 - 사용자 요청이 들어올 때마다 Thread 를 새로 생성해서 사용자 요청을 처리하도록 한다.
 * step3 - Thread Pool 을 적용해 안정적인 서비스가 가능하도록 한다.
 */

public class CustomWebApplicationServer {
    private final int port;

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] Started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");

                /**
                 * step2 - 사용자 요청이 들어올 때마다 Thread 를 새로 생성해서 사용자 요청을 처리하도록 한다.
                 * 문제점: 쓰레드가 생성될 때마다 스택 메모리를 할당 받음 -> 성능 하락, CPU ContextSwitching 증가
                 * 해결: 고정된 쓰레드 개수만 생성하여 재사용
                 */

                new Thread(new ClientRequestHandler(clientSocket)).start();

            }
        }
    }
}
