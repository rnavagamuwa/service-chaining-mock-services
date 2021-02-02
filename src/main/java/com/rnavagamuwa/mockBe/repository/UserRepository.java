package com.rnavagamuwa.mockBe.repository;

import com.rnavagamuwa.mockBe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rnavagamuwa
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findBySsn(String ssn);
}
