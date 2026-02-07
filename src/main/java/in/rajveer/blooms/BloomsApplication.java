package in.rajveer.blooms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BloomsApplication {

    private static final Logger logger = LoggerFactory.getLogger(BloomsApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(BloomsApplication.class, args);

        String mongoUri = context.getEnvironment().getProperty("spring.data.mongodb.uri");
        logger.info("--------------------------------------------------");
        logger.info("🔥 MY MONGO URI IS: " + mongoUri);
        logger.info("--------------------------------------------------");
    }
}
