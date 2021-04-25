package com.group25.ebnisina.manageprocess.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@IdClass(ProcessId.class) // Composite key
public class Process {
    @Id
    private int laboratorian_id;

    @Id
    private int request_id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date_time;

    private String comment;
}
