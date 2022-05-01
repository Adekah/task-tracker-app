package com.adekah.taskTrackerApp.util;

public class ApiPaths {

    private static final String BASE_PATH = "/api";

    public static final class TaskController {
        public static final String CTRL = BASE_PATH + "/task";
    }

    public static final class ProjectController {
        public static final String CTRL = BASE_PATH + "/project";
    }

    public static final class UserController {
        public static final String CTRL = BASE_PATH + "/user";
    }
}
