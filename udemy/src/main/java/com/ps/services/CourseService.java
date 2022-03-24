package com.ps.services;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.ps.domain.Course;
import com.ps.repository.CourseRepository;
import com.ps.repository.CourseRepositoryImplementation;

public class CourseService {
    public Course createCourse(Course course) throws SQLException, NamingException{
        CourseRepository courseImpl=new CourseRepositoryImplementation();
        return courseImpl.create(course);
    }
}
