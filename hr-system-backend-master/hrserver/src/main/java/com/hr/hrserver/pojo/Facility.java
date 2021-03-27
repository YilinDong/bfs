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

@Table(name="Facility")
public class Facility {
    @Id
    @Column(name="ID")
    int ID;
    @Column(name="HouseID")
    int HouseID;
    @Column(name="Type")
    String type;
    @Column(name="Description")
    String description;
    @Column(name="Quantity")
    int quantity;
}
