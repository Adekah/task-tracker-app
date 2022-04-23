package com.adekah.taskTrackerApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="task")
@NoArgsConstructor // Empty constructor
@AllArgsConstructor //Full constructor
@ToString
@EqualsAndHashCode
public class Task extends BaseEntity {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "description", length = 400)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;
}
