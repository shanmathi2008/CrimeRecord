package com.CrimeRecord.CrimeRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VictimWitnessRepository
        extends JpaRepository<VictimWitness, String> {
}