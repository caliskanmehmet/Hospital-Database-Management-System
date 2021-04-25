package com.group25.ebnisina.managetestrequests.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TestRequest {
    @Id
    private int request_id;

    private String status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime request_date_time;

    private String name;

    int app_id;

    int test_type_id;
}
