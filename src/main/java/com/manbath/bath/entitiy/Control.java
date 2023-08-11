package com.manbath.bath.entitiy;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.hibernate.annotations.ColumnDefault;
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

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private com.manbath.bath.entitiy.User userid;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bathid")
    private Bath bathid;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scheduleid")
    private Schedule scheduleid;

    @ColumnDefault("0")
    @Column(name = "temp")
    private float temp;

    @ColumnDefault("0")
    @Column(name = "level")
    private int level;

    @ColumnDefault("0")
    @Column(name = "cap")
    private int cap;

    @ColumnDefault("0")
    @Column(name = "h_valve")
    private int h_valve;

    @ColumnDefault("0")
    @Column(name = "c_valve")
    private int c_valve;

    @ColumnDefault("0")
    @Column(name = "cleantime")
	private int cleantime;

    @CreationTimestamp
	@Column(name = "time")
	private LocalDateTime time;
}
