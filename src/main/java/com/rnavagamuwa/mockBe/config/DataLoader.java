package com.rnavagamuwa.mockBe.config;

import com.rnavagamuwa.mockBe.model.ValidationPairs;
import com.rnavagamuwa.mockBe.repository.ValidationPairsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rnavagamuwa
 */
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ValidationPairsRepository validationPairsRepository;

    public void run(ApplicationArguments args) {
        List<ValidationPairs> validationPairs = new ArrayList<>();
        validationPairs.add(new ValidationPairs("device_19th6281", "userservice"));
        validationPairs.add(new ValidationPairs("device_29ihs6288", "branchservice"));

        validationPairsRepository.saveAll(validationPairs);
    }
}
