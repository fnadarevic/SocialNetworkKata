import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

@ExtendWith(MockitoExtension.class)
public class PostTest {


        @InjectMocks
        Post post;

        @Test
        public void elapsedTimeSeconds() {
            LocalTime localTime = LocalTime.now();
            post.setMessage("test message");
            post.setLocalTime(localTime.minusSeconds(10));
            Assertions.assertEquals("10 seconds ago)", post.elapsedTime(localTime));
        }

        @Test
        public void elapsedTimeMinutes(){
            LocalTime localTime = LocalTime.now();
            post.setMessage("test message");
            post.setLocalTime(localTime.minusMinutes(10));
            Assertions.assertEquals("10 minutes ago)", post.elapsedTime(LocalTime.now()));
        }

        @Test
        public void elapsedTimeHours() {
            LocalTime localTime = LocalTime.now();
            post.setMessage("test message");
            post.setLocalTime(localTime.minusHours(5));
            Assertions.assertEquals("5 hours ago)", post.elapsedTime(LocalTime.now()));
        }
    }
