package com.hr.hrserver.pojo;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="RegistrationToken")
public class RegistrationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    public String ID;
    @Column(name="Token")
    public String Token;
    @Column(name="ValidDuration")
    public final static int VALIDDURATION = 60*3;
    @Column(name="Email")
    public String email;
    @Column(name="CreatedBy")
    public Date CreateBy;

}
