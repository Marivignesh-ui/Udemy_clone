package com.ps.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ps.domain.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserRepositoryImpl implements UserRepository{
    private static final Logger logger=LogManager.getLogger(UserRepositoryImpl.class);

    public User create(User user){
        DataSource ds=null;
        try{
            ds=DBConnectionManager.getDBConnection();
        }catch(NamingException e){
            logger.info(e);
            e.printStackTrace();
        }
        try(Connection conn=ds.getConnection();
            PreparedStatement statement=conn.prepareStatement("insert into User values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ){
            statement.setString(1, user.getId());
            statement.setString(2, user.getFirstname());
            statement.setString(3, user.getLastname());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getAvatarUrl());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getMobilenumber());
            statement.setString(8, Arrays.toString(user.getInterests()));
            statement.setString(9, Arrays.toString(user.getCourses()));
            statement.setString(10, Arrays.toString(user.getFavorites()));
            statement.setString(11, Arrays.toString(user.getCart()));
            statement.setBoolean(12, user.isStatus());
            statement.setDate(13, Date.valueOf(user.getCreatedDate()));
            statement.setDate(14, Date.valueOf(user.getLastLoginDate()));

            int count=statement.executeUpdate();
            if(count>0){
                logger.info(user);
                return user;
            }
            
        }catch(SQLException e){
            logger.info(e);
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsers(){
        List<User> users=new ArrayList<User>();
        DataSource ds=null;
        try{
            ds=DBConnectionManager.getDBConnection();
        }catch(NamingException e){
            logger.info(e);
            e.printStackTrace();
        }
        try(Connection conn=ds.getConnection();
            Statement statement=conn.createStatement();
            ResultSet rSet=statement.executeQuery("select * from users");
        ){
            while(rSet.next()){
                String id=rSet.getString("id");
                String firstname=rSet.getString("firstname");
                String lastname=rSet.getString("lastname");
                String password=rSet.getString("password");
                String avatarUrl=rSet.getString("avatarurl");
                String email=rSet.getString("email");
                String mobilenumber=rSet.getString("mobile");
                String[] interests=rSet.getString("interests").split(",");
                String[] courses=rSet.getString("courses").split(",");
                String[] favorites=rSet.getString("favorites").split(",");
                String[] cart=rSet.getString("cart").split(",");
                boolean status=rSet.getBoolean("status");
                String createdDate=rSet.getDate("createddate").toString();
                String lastLoginDate=rSet.getDate("lastlogindate").toString();

                User user=new User(firstname, lastname, password, avatarUrl, email, mobilenumber, interests, courses, favorites, cart, status, createdDate, lastLoginDate);
                users.add(user);
            }

            return users;

        }catch(SQLException e){
            logger.info(e);
            e.printStackTrace();
        }
        return users;
    }
}
