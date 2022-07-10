package africa.semicolon.eventBrite.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
public class Event {
    @Id
    private String id;
    private String theme;
    private String location;

}
