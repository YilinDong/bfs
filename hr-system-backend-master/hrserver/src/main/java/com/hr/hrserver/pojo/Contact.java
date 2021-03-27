package com.hr.hrserver.pojo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Contact")
public class Contact {
    @Id
    @Column(name="ID")
    int ID;
    @Column(name="EmployeeID")
    int EmployeeID;
    @Column(name="Relationship")
    String Relationship;
    @Column(name="Title")
    String Title;
    @Column(name="isReference")
    int isReference;
    @Column(name="isEmergency")
    int isEmergency;
    @Column(name="isLandlord")
    int isLandlord;
    @Column(name="cellPhone")
    String cellPhone;
}
