package com.greenfoxacademy.hta.models.bloodlabdata;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Calcium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double value;
    private LocalDateTime measureTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private BloodLabData bloodLabData;

    public Calcium(double value, LocalDateTime measureTime) {
        this.value = value;
        this.measureTime = measureTime;
    }
}
