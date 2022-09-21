package org.example;

/**
 * step1 - 사용자 요청을 메인 Thread 가 처리하도록 한다.
 * step2 - 사용자 요청이 들어올 때마다 Thread 를 새로 생성해서 사용자 요청을 처리하도록 한다.
 * step3 - Thread Pool 을 적용해 안정적인 서비스가 가능하도록 한다.
 */

/**
 * HTTP
 * - 서버와 클라이언트가 웹에서 데이터를 주고받기 위한 프로토콜
 * - 참고
 *   ㄴ HTTP/1.1, HTTP/2는 TCP 기반 위에서 동작(TCP: 3way handshake 연결)
 *   ㄴ HTTP/3는 UDP 기반 위에서 동작((UDP: 3way handshake 연결 X)
 */

/**
 * HTTP 요청/응답 메시지 구조
 * 클라이언트 요청 : Request line -> Header -> Blank line -> Body
 * 서버 응답: Status line -> Header -> Blank line -> Body
 */

/**
 * HTTP 특징
 * - 클라이언트 서버 모델
 * - 무상태 프로토콜(Stateless)
 *   ㄴ 서버가 클라인트 상태를 유지하지 않음
 *   ㄴ 해결책: Keep-Alive 속성 사용 (keep-Alive: 요청-응답이 끝나고 바로 연결을 끊지 않고 특정 시간동안 연결 유지)
 * - 비연결성(Connectionless)
 *   ㄴ 서버가 클라이언트 요청에 대해 응답을 마치면 맺었던 연결을 끊어 버림
 *   ㄴ 해결책: 쿠키(클라이언트에 정보 저장), 세션(서버에 정보 저장), JWT
 */

/**
 * HTTP 요청 메소드
 * - GET, POST, PUT, DELETE 등
 * HTTP 응답 코드
 * - 2xx(성공), 3xx(리다이렉션), 4xx(클라이언트 에러), 5xx(서버 에러) 등
 * HTTP 헤더
 * - Content-type, Accept, Cookie, Set-Cookie, Authorization 등
 */

/**
 * 객체 설계
 * HttpRequest
 *   - RequestLine (GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1)
 *      - HttpMethod
 *      - path
 *      - queryString
 *   - Header
 *   - Body
 *
 *  HttpResponse
 */

import java.io.IOException;
// GET /calculate?operand1=11&operator=*&operand2=55
public class Main {
    public static void main(String[] args) throws IOException {
        new CustomWebApplicationServer(8080).start();
    }
}