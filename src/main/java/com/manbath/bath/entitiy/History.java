package com.manbath.bath.entitiy;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity(name="history")
@NoArgsConstructor
@AllArgsConstructor
public class History {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long historyid;
	
	@ManyToOne
    @JoinColumn(name = "userid")
    private com.manbath.bath.entitiy.User userid;
	
	@ManyToOne
    @JoinColumn(name = "bathid")
    private Bath bathid;
    
    @Column(name = "start_time")
    private LocalDateTime start_time;
    
    @Column(name = "end_time")
    private LocalDateTime end_time;
    
    @Column(name = "bath_time")
    private int bath_time;
    
    @Column(name = "temp")
    private float temp;
    
    @Column(name = "level")
    private int level;
    
    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
