package com.hr.hrserver.pojo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    String Phone;
    @Column(name="Name")
    String Name;
    @Column(name="Email")
    String Email;

//    @ManyToOne
//    @JoinColumn(name = "EmployeeID")
//    Employee e;
}

