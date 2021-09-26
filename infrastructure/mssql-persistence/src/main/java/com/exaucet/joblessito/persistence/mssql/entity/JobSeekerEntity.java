package com.exaucet.joblessito.persistence.mssql.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity(name = "JobSeeker")
@Table(name = "JobSeeker")
@Getter
@Setter
@EqualsAndHashCode
public class JobSeekerEntity {
    @Id
    @SequenceGenerator(initialValue = 20202, allocationSize = 100, name = "jobseekerSeqGenerator", sequenceName = "jobSeekerSeq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobSeekerSeq")
    Long id;
    @Positive
    Integer age;
    @Email
    @NotNull
    String email;
    @NotNull String education;
    @NotNull String username;
}
