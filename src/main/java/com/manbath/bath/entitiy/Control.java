package com.manbath.bath.entitiy;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

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

    @OneToOne
    @JoinColumn(name = "scheduleid")
    private Schedule scheduleid;
	
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
    
    @Column(name = "cleantime")
	private int cleantime;
    
    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
