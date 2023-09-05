package com.multiple.schema.timeline;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/timeline")
public class TimelineController {

    private final TimelineRepository repository;

    public TimelineController(final TimelineRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        final List<TimelineJpaEntity> all = repository.findAll();

        List<TimelineDTO> list = all.stream()
                .map(TimelineDTO::from)
                .toList();

        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TimelineDTO timelineDTO) {
        final TimelineJpaEntity timelineJpa = timelineDTO.toAggregate();

        final TimelineJpaEntity save = repository.save(timelineJpa);

        return ResponseEntity.ok(TimelineDTO.from(save));
    }

    record TimelineDTO(MobileDTO mobile,
                       UnitDTO unit) {
        public static TimelineDTO from(final TimelineJpaEntity timelineJpa) {
            return new TimelineDTO(
                    new MobileDTO(timelineJpa.getMobile().getId(), timelineJpa.getMobile().getName()),
                    new UnitDTO(timelineJpa.getUnit().getId(), timelineJpa.getUnit().getName())
            );
        }

        public TimelineJpaEntity toAggregate() {
            return new TimelineJpaEntity(
                    this.mobile().toAggregate(),
                    this.unit().toAggregate()
            );
        }
    }

    record MobileDTO(Integer id, String name) {
        public MobileJpaEntity toAggregate() {
            return new MobileJpaEntity(this.name());
        }
    }

    record UnitDTO(Integer id, String name) {
        public UnitJpaEntity toAggregate() {
            return new UnitJpaEntity(this.name());
        }
    }
}
