package com.ps.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ps.domain.Course;

public class CourseRepositoryImplementation implements CourseRepository{
    public Course create(Course course) throws SQLException, NamingException{
        //DataSource ds=DBConnectionManager.getDBConnection();
        try(//Connection connection=ds.getConnection();
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy_clone?user=root");
            PreparedStatement statement=connection.prepareStatement("insert into Course values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ){
            statement.setInt(1, course.getId());
            statement.setString(2, course.getTitle());
            statement.setString(3, course.getAuthor());
            statement.setString(4, course.getDescription());
            statement.setString(5, course.getCategory());
            statement.setString(6, course.getImageUrl());
            statement.setDate(7, Date.valueOf(course.getLastUpdated()));
            statement.setFloat(8, course.getRating());
            statement.setLong(9, course.getNumberOfRatings());
            statement.setBoolean(10, course.isBestSeller());
            statement.setInt(11, course.getOriginalPrice());
            statement.setInt(12, course.getDiscountPrice());
            statement.setString(13, course.getLevel());

            int count=statement.executeUpdate();
            if(count>0) return course;
        }
        return null;
    }
    
}
