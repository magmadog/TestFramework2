package org.example.model;

import java.util.Date;

public class Project {
    private Integer id;
    private Date startDate;
    private String name;

    public Project() {
        super();
    }

    public Project(Integer projectId, Date startDate, String name) {
        id = projectId;
        this.startDate = startDate;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
