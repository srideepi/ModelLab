package com.batch2.artifact1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch2.artifact1.domain.Accountant;

public interface AccountantRepo extends JpaRepository<Accountant, Long> {

}
