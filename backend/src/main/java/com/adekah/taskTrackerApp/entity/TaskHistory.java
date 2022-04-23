package com.adekah.taskTrackerApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "task_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TaskHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "task_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Task task;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;
}
