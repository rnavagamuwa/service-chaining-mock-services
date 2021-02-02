package com.rnavagamuwa.mockBe.repository;

import com.rnavagamuwa.mockBe.model.ValidationPairs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rnavagamuwa
 */
@Repository
public interface ValidationPairsRepository extends JpaRepository<ValidationPairs, Long> {

    List<ValidationPairs> findAllByScopeIs(String scope);
}
