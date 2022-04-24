package com.adekah.taskTrackerApp.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_code", unique = true)
    private String projectCode;

    @Column(name = "project_name")
    private String projectName;

    @JoinColumn(name="manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }
}
