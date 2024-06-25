package com.banquito.core.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.core.client.model.Segment;

public interface SegmentRepository extends JpaRepository<Segment, String> {

}
