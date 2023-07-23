package com.manbath.bath.entitiy;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name="info")
@NoArgsConstructor
@AllArgsConstructor
public class Info {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long infoid;
    
	@ManyToOne
    @JoinColumn(name = "bathid")
    private Bath bathid;

    @Column(name = "state")
    private int state;

    @Column(name = "temp")
    private float temp;
    
    @Column(name = "level")
    private int level;
    
    @Column(name = "cap")
    private int cap;
    
    @Column(name = "h_valve")
    private int h_valve;
    
    @Column(name = "c_valve")
    private int c_valve;
    
    @Column(name = "fan")
    private int fan;
    
    @Column(name = "haet")
    private int heat;
    
    @Column(name = "clean_valve")
    private int clean_valve;
    
    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
