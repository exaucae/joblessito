package com.exaucet.joblessito.persistence.mssql.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    Long id;
    @Positive
    Integer age;
    @Email
    @NotNull
    String email;
    @NotNull String education;
    @NotNull String username;
}
