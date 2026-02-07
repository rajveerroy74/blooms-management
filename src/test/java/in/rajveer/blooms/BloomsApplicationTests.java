package in.rajveer.blooms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.data.mongodb.uri=mongodb://localhost:27017/test")
class BloomsApplicationTests {

	@Test
	void contextLoads() {
	}

}
