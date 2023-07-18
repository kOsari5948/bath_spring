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
@Entity(name="schedule")
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long scheduleid;
    
	@ManyToOne
    @JoinColumn(name = "userid")
    private com.manbath.bath.entitiy.User userid;
	
	@ManyToOne
    @JoinColumn(name = "bathid")
    private Bath bathid;
	
    @Column(name = "temp")
    private int temp;
    
    @Column(name = "level")
    private int level;
    
    @Column(name = "cleantime")
   	private int cleantime;
    
    @Column(name = "starttime")
   	private LocalDateTime starttime;
    
    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
