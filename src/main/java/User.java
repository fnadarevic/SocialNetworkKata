import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    String name;
    List<Post> posts = new ArrayList<>();
    Timeline timeline;
    List<User> following;

    public void publish(String message, User user, LocalTime localTime){
        Post post = new Post();
        post.setMessage(message);
        post.setUser(user);
        post.setLocalTime(localTime);
        posts.add(post);
    }


}
