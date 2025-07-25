package com.school.courseService.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.school.courseService.dto.CourseDTO;
import com.school.courseService.entity.Course;
import com.school.courseService.exception.ResourceNotFoundException;
import com.school.courseService.repository.CourseRepository;
import com.school.courseService.service.CourseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        return modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public CourseDTO createCourse(CourseDTO dto) {
        Course course = modelMapper.map(dto, Course.class);
        return modelMapper.map(courseRepository.save(course), CourseDTO.class);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        modelMapper.map(dto, course);
        return modelMapper.map(courseRepository.save(course), CourseDTO.class);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        courseRepository.delete(course);
    }
}
