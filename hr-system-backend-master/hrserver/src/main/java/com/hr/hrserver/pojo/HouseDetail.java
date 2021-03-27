package com.hr.hrserver.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HouseDetail{
    public Address address;
    public List<Occupant> occupantList;
}
