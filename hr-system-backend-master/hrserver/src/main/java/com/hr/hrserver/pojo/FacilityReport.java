package com.hr.hrserver.pojo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

@Table(name = "FacilityReport")
public class FacilityReport {
    @Id
    @Column(name="ID")
    int ID;
    @Column(name="EmployeeID")
    int EmployeeID;
    @Column(name="ReportDate")
    Date ReportDate;
    @Column(name="Title")
    String Title;
    @Column(name="Description")
    String Description;
    @Column(name="Status")
    String Status;

}
