package com.multiple.schema.timeline;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelineRepository extends JpaRepository<TimelineJpaEntity, Integer> {
}
