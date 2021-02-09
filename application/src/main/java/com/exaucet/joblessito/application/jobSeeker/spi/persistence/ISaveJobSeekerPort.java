package com.exaucet.joblessito.application.jobSeeker.spi.persistence;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;
import com.exaucet.joblessito.common.control.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

public interface ISaveJobSeekerPort {
    Optional<JobSeeker> handle(SaveJobSeekerCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class SaveJobSeekerCommand extends SelfValidating<SaveJobSeekerCommand> {
        Long id;
        @Positive
        Integer age;
        @Email
        @NotNull
        String email;
        @NotNull String education;
        @NotNull String username;

        public SaveJobSeekerCommand(Long id, Integer age, String email, String education, String username) {
            this.id = id;
            this.age = age;
            this.email = email;
            this.education = education;
            this.username = username;
            this.validateSelf();
        }
    }
}
