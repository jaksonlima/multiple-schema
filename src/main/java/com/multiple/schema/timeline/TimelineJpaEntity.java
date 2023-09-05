package com.multiple.schema.timeline;

import jakarta.persistence.*;

@Entity
@Table(schema = "public", name = "timeline")
public class TimelineJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mobile_id", referencedColumnName = "id")
    private MobileJpaEntity mobile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private UnitJpaEntity unit;

    public TimelineJpaEntity() {
    }

    public TimelineJpaEntity(final MobileJpaEntity mobile,
                             final UnitJpaEntity unit) {
        this.mobile = mobile;
        this.unit = unit;

        mobile.setTimeline(this);
        unit.setTimeline(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MobileJpaEntity getMobile() {
        return mobile;
    }

    public void setMobile(MobileJpaEntity mobile) {
        this.mobile = mobile;
    }

    public UnitJpaEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitJpaEntity unit) {
        this.unit = unit;
    }
}
