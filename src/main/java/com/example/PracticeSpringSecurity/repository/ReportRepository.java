package com.example.PracticeSpringSecurity.repository;

import com.example.PracticeSpringSecurity.repository.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
}
