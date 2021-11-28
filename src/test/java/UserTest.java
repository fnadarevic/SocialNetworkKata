import org.junit.jupiter.api.*;

import java.time.LocalTime;
import java.util.List;

public class UserTest {

    @Test
    public void testAlicePosts(){
        User userAlice = new User();
        userAlice.publish("I love the weather today!", userAlice, LocalTime.now());
        Assertions.assertEquals("I love the weather today!", userAlice.getPosts().get(0).getMessage());
    }

    @Test
    public void testAlicePostsOnTimeline(){
        User userAlice = new User();
        userAlice.setName("Alice");
        userAlice.publish("I love the weather today!", userAlice, LocalTime.now());
        Timeline timeline = new Timeline();
        List<Post> posts = userAlice.getPosts();
        timeline.setPosts(posts);
        userAlice.setTimeline(timeline);
        Assertions.assertEquals("I love the weather today!", userAlice.getTimeline().getPosts().get(0).getMessage());
    }

    @Test
    public void testAlicePostsOnTimelineTwice(){
        User userAlice = new User();
        userAlice.setName("Alice");
        userAlice.publish("I love the weather today!", userAlice, LocalTime.now());
        LocalTime localTime = LocalTime.now();
        userAlice.publish("The weather is still great!", userAlice, localTime.minusMinutes(5));
        Timeline timeline = new Timeline();
        List<Post> posts = userAlice.getPosts();
        timeline.setPosts(posts);
        userAlice.setTimeline(timeline);
        Assertions.assertEquals("I love the weather today!", userAlice.getTimeline().getPosts().get(0).getMessage());
        Assertions.assertEquals("The weather is still great!", userAlice.getTimeline().getPosts().get(1).getMessage());
        Assertions.assertEquals(true, userAlice.getTimeline().getPosts().get(1).postForTimeLine().contains("(5 minutes ago)"));
    }
}
