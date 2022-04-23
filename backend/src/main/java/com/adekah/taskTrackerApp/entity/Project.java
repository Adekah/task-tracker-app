package com.adekah.taskTrackerApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "project_code", unique = true)
    private String projectCode;

    @Column(name = "project_name")
    private String projectName;
}
