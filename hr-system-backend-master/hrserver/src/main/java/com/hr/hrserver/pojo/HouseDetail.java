package com.hr.hrserver.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HouseDetail{
    public Address address;
    public List<Occupant> occupantList;
}
