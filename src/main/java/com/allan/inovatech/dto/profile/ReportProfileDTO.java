package com.allan.inovatech.dto.profile;


import com.allan.inovatech.model.entities.Report;
import com.allan.inovatech.model.enums.Status;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReportProfileDTO(

        Integer id,
        String reportDescription,
        Status sts,
        LocalDate sendDate,
        LocalTime amountHours

) {
    public static ReportProfileDTO fromEntity(Report report) {
        return new ReportProfileDTO(
                report.getId(),
                report.getReportDescription(),
                report.getSts(),
                report.getSendDate(),
                report.getAmountHours()
        );
    }
}
