package com.CrimeRecord.CrimeRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SuspectRepository extends JpaRepository<Suspect, String> {
}