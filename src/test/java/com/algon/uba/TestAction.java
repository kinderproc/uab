package com.algon.uba;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table("test_actions")
@Data
public class TestAction {
    @PrimaryKey
    @Column("user_id")
    private String userId;
    @Column("action")
    private String action;
    @Column("event_time")
    private LocalDateTime eventTime;
}
