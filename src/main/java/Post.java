import lombok.Data;
import org.assertj.core.util.VisibleForTesting;
import java.time.Duration;
import java.time.LocalTime;

@Data
public class Post {
    User user;
    String message;
    LocalTime localTime;

    @VisibleForTesting
    String elapsedTime(LocalTime now){
        Duration duration = Duration.between(localTime, now);
        if (duration.getSeconds() != 0 && duration.toHours() == 0 && duration.toMinutes() == 0){
            return duration.getSeconds() + " seconds ago)";
        }else if (duration.toHours() != 0) {
            return duration.toHours() + " hours ago)";
        }else  if(duration.toMinutes() != 0 && duration.toHours() == 0){
            return duration.toMinutes() + " minutes ago)";
        }else{
            return "less than a second ago)";
        }
    }

    public String postForTimeLine(){
        return user.getName() + " - " + message + " (" + elapsedTime(LocalTime.now());
    }
}
