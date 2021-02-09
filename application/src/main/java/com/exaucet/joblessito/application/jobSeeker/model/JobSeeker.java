package com.exaucet.joblessito.application.jobSeeker.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public class JobSeeker {
    private Long id;
    private Integer age;
    private String email;
    private String education;
    private String username;
}
