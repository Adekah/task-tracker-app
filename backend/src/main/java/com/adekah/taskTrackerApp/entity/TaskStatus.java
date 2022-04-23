package com.adekah.taskTrackerApp.entity;

import lombok.Data;

import javax.persistence.MappedSuperclass;


public enum TaskStatus {
    OPEN,
    CLOSED,
    IN_REVIEW,
    IN_PROGRESS,
    RESOLVED
}
