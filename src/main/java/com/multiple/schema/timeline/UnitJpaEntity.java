package com.multiple.schema.timeline;

import jakarta.persistence.*;

@Entity
@Table(schema = "public", name = "unit")
public class UnitJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "unit")
    private TimelineJpaEntity timeline;

    public UnitJpaEntity() {
    }

    public UnitJpaEntity(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimelineJpaEntity getTimeline() {
        return timeline;
    }

    public void setTimeline(TimelineJpaEntity timeline) {
        this.timeline = timeline;
    }
}
