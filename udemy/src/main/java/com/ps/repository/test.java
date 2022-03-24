package com.ps.repository;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.ps.domain.Course;

public class test {
    public static void main(String[] args) throws SQLException, NamingException {
        CourseRepositoryImplementation ob=new CourseRepositoryImplementation();
        Course course=new Course(1, "Learn Python:The complete python programming course", "Avinash Jain", "Learn A-Z everything about Python, from the basics, to advanced topics like Python GUI, Python Data Analysis, and more!Create their own Python ProgramsBecome an experienced Python ProgrammerParse the Web and Create their own Games", "Python", "https://image", "2016-09-01", 4.5f, 2000, false, 2500, 450, "Beginner");
        Course course1=ob.create(course);
        System.out.println(course1);
    }
}
