package com.algon.uba;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("test_events")
@Data
public class TestEvent {
    @Id
    private String id;
    private String message;
}
