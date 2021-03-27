package com.hr.hrserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Role")
public class Role {
    @Id
    @Column(name="ID")
    public int ID;
    @Column(name="RoleName")
    public String RoleName;
    @Column(name="Description")
    public String Description;
    @Column(name="CreateDate")
    public Date CreatedDate;
    @Column(name="LastModificationDate")
    public Date LastModificationDate;
    @Column(name="LastModificationUserID")
    public int LastModificationUserID;

}
