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
    private LocalDateTime bath_time;
    
    @Column(name = "temp")
    private int temp;
    
    @Column(name = "level")
    private int level;
    
    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
