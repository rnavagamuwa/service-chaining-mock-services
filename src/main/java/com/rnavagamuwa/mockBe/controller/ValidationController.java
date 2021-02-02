package com.rnavagamuwa.mockBe.controller;

import com.rnavagamuwa.mockBe.model.ValidationPairs;
import com.rnavagamuwa.mockBe.repository.ValidationPairsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author rnavagamuwa
 */
@RestController
@RequestMapping("/api")
public class ValidationController {
    
    @Autowired
    private ValidationPairsRepository validationPairsRepository;

    @PostMapping("/validate")
    public ValidationResponse validateRequest(@Valid @RequestBody ValidationPairs pair) {
        String[] scopes = pair.getScope().replace("[","").replace("]","").split(",");
        for (String scope: scopes) {
            List<ValidationPairs> validationPairs = validationPairsRepository.findAllByScopeIs(scope);
            for (ValidationPairs validationPair:validationPairs) {
                if (validationPair.getService().equals(pair.getService())){
                    return new ValidationResponse(true,false,null);
                }
            }
        }
        return new ValidationResponse(false,false,"Validation has failed");
    }


    private class ValidationResponse{
        private boolean isValidated;
        private boolean isError;
        private String message;

        public ValidationResponse(boolean isValidated, boolean isError, String error) {
            this.isValidated = isValidated;
            this.isError = isError;
            this.message = error;
        }

        public boolean isValidated() {
            return isValidated;
        }

        public void setValidated(boolean validated) {
            isValidated = validated;
        }

        public boolean getMessage() {
            return isError;
        }

        public void setMessage(boolean message) {
            isError = message;
        }

        public String getError() {
            return message;
        }

        public void setError(String error) {
            this.message = error;
        }
    }
}
