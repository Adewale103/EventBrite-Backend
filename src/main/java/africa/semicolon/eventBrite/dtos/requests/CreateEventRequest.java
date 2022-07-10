package africa.semicolon.eventBrite.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {
    private String email;
    private String eventName;
    private String eventLocation;
}
