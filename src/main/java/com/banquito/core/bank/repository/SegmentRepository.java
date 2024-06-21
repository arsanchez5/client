package com.banquito.core.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.bank.model.Segment;

public interface SegmentRepository extends JpaRepository<Segment, String> {

}
