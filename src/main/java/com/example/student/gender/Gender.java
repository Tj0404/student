package com.example.student.gender;

public enum Gender {
    M("남"),
    F("여");

    public final String description;

    Gender(String description) {
        this.description = description;
    }

}
