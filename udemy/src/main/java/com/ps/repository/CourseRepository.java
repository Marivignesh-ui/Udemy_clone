package com.ps.repository;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.ps.domain.Course;

public interface CourseRepository {
    public Course create(Course course)throws SQLException,NamingException;
}
