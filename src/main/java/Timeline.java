import lombok.Data;

import java.util.List;

@Data
public class Timeline {
    List<Post> posts;
    List<User> followedUser;
}
