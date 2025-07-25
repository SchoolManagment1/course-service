package com.school.courseService.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String title;
    private String category;
    private String instructor;
    private String duration;
    private LocalDate startDate;
    private double fees;
    private boolean enrolled;
    private int rating;
    private String tag;
}
