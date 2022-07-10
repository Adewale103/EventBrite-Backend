package africa.semicolon.eventBrite.dtos.responses;

import lombok.Data;

@Data
public class CreateEventResponse {
    private String location;
    private String createdBy;
    private String partyName;
}
