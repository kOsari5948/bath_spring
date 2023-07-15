package com.manbath.bath.entitiy;

import java.time.LocalDateTime;

import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Entity(name="control")
@NoArgsConstructor
@AllArgsConstructor
public class Control {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long controlid;
    
    
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
    
    @Column(name = "cap")
    private int cap;
    
    @Column(name = "h_valve")
    private int h_valve;
    
    @Column(name = "c_valve")
    private int c_valve;
    
    @Column(name = "clean_valve")
    private int clean_valve;
    
    @Column(name = "cleantime")
	private int cleantime;
    
    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
