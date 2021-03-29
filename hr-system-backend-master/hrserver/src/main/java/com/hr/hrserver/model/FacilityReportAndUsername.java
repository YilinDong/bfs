package com.hr.hrserver.model;

import com.hr.hrserver.pojo.FacilityReport;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@ToString
public class FacilityReportAndUsername {
    FacilityReport facilityReport;
    String username;
}
