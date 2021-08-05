package com.example.asyncWebClient

import com.example.asyncWebClient.model.User
import com.example.asyncWebClient.service.UserService
import groovy.util.logging.Slf4j
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.ArgumentMatchers;
import static org.mockito.Mockito.when;


@Slf4j
@SpringBootTest
class AsyncWebClientApplicationTests {

	@Autowired
	UserService userService

	@Mock
	WebClient webClientMock

	@SuppressWarnings("rawtypes")
	@Mock
	private WebClient.RequestHeadersSpec requestHeadersSpecMock;

	@SuppressWarnings("rawtypes")
	@Mock
	private WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

	@Mock
	private WebClient.ResponseSpec responseSpecMock

	@Test
	void contextLoadUser() {
		userService
				.getUserByIdAsync("1")
				.subscribe(user -> log.info("Get user async: {}", user))
	}

	@Test
	void contextLoadUserAndCheck() {

		Mono<User> userMono =  userService
				.getUserByIdAsync("1");

		StepVerifier.create(userMono)
				.expectNextMatches( user-> user.getEmail()
						.equals("Sincere@april.biz"))
				.verifyComplete();
	}

	@Test
	void contextMockUserAndCheck() {
		UserService userService = new UserService(webClientMock)
		User userDummy = new User();
		userDummy.setName("Abhishek")
		userDummy.setId(1)
		userDummy.setEmail("a@a.com")

		when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock)
		when(requestHeadersUriSpecMock.uri("/users/{id}","1")).thenReturn(requestHeadersSpecMock)
		when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock)
		when(responseSpecMock.bodyToMono(User.class)).thenReturn(Mono.just(userDummy))

		Mono<User> userMono =  userService
				.getUserByIdAsync("1");

		StepVerifier.create(userMono)
				.expectNextMatches( user-> user.getEmail()
						.equals("a@a.com"))
				.verifyComplete();
	}

	@Test
	void contextMockWebServerUserAndCheck() {

		Mono<User> userMono =  userService
				.getUserByIdAsync("1");

		StepVerifier.create(userMono)
				.expectNextMatches( user-> user.getEmail()
						.equals("Sincere@april.biz"))
				.verifyComplete();
	}
}
