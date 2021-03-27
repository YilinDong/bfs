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
@Table(name="DigitalDocument")
public class DigitalDocument {
    @Id
    @Column(name="ID")
    int ID;
    @Column(name="Type")
    String type;
    @Column(name="Required")
    int required;
    @Column(name="TemplateLocation")
    String templateLocation;
    @Column(name="Description")
    String description;
    @Column(name="Title")
    String title;
}
