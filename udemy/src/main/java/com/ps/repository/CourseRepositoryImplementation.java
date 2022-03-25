package com.ps.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ps.domain.Course;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CourseRepositoryImplementation implements CourseRepository{
    private static final Logger logger = LogManager.getLogger(CourseRepositoryImplementation.class);
    public Course create(Course course){
        DataSource ds=null;
        try {
            ds = DBConnectionManager.getDBConnection();
        } catch (NamingException e) {
            e.printStackTrace();
            logger.info(e);
        }
        try(Connection connection=ds.getConnection();
            //Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy_clone?user=root");
            PreparedStatement statement=connection.prepareStatement("insert into Course values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ){
            logger.info("DB connection success");
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
            if(count>0){
                logger.info("DB updation success");
                return course;
            } 
        }catch(SQLException e){
            logger.info(e);
            e.printStackTrace();
        }
        return null;
    }
    
}
