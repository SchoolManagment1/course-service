package com.school.courseService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.courseService.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
