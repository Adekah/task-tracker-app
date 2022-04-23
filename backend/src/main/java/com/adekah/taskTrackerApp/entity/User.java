package com.adekah.taskTrackerApp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "uname",length = 100,unique = true)
    private String username;

    @Column(name = "name_surname",length = 50)
    private String nameSurname;

    @Column(name = "pwd")
    private String password;

    @Column(name = "email",length = 100)
    private String email;

    @JoinColumn(name="assignee_user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Task> tasks;
}
