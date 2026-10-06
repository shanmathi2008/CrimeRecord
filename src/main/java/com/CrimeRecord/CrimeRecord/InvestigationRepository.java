package com.CrimeRecord.CrimeRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestigationRepository extends JpaRepository<Investigation, String> {
}