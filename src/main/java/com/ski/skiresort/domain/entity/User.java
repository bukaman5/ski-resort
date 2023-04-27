package com.ski.skiresort.domain.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    private String id;
    private String name;
    private String userPic;
    private LocalDateTime lastVisit;

}
