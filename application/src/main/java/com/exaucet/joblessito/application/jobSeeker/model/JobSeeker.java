package com.exaucet.joblessito.application.jobSeeker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class JobSeeker {
    private Long id;
    private Integer age;
    private String email;
    private String education;
    private String username;
}
