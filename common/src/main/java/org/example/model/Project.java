package org.example.model;

import lombok.Data;

import java.util.Date;

@Data
public class Project {
    private Integer id;
    private Date startDate;
    private String name;
}
