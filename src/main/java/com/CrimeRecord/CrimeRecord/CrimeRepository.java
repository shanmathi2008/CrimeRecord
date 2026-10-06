package com.CrimeRecord.CrimeRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeRepository extends JpaRepository<Crime, String> {
}