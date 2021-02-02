package com.rnavagamuwa.mockBe.model;

import javax.persistence.*;

/**
 * @author rnavagamuwa
 */
@Entity
@Table(name = "validationPairs")
public class ValidationPairs {
    @Id
    @Column(name = "pairID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pairID;
    private String scope;
    private String service;

    public ValidationPairs() {
    }

    public ValidationPairs(String scope, String service) {
        this.scope = scope;
        this.service = service;
    }

    public long getPairID() {
        return pairID;
    }

    public void setPairID(long pairID) {
        this.pairID = pairID;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
