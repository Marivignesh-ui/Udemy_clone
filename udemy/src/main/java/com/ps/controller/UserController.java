package com.ps.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ps.domain.User;
import com.ps.services.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = {"/user"})
public class UserController extends HttpServlet{
    private static final Logger logger=LogManager.getLogger(UserController.class);
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) {
        try(InputStream is=req.getInputStream();
            JsonReader reader=Json.createReader(is);
        ){
            JsonObject json=reader.readObject();
            String firstname=json.getString("firstname");
            String lastname=json.getString("lastname");
            String password=json.getString("password");
            String avatarUrl=json.getString("avatarurl");
            String email=json.getString("email");
            String mobilenumber=json.getString("mobile");
            String[] interests={};
            String[] courses={};
            String[] favorites={};
            String[] cart={};
            boolean status=json.getBoolean("status");
            String createdDate=json.getString("createddate");
            String lastLoginDate=json.getString("lastlogindate");
            
            User user=new User(firstname, lastname, password, avatarUrl, email, mobilenumber, interests, courses, favorites, cart, status, createdDate, lastLoginDate);
            logger.info("User object created successfully from request");
            UserService userService=new UserService();
            User user1=userService.CreateUser(user);
            logger.info("returned user object:"+user1);
            
            String response="<html><head><title>User</title></head><body>"+user1+"</body></html>";
            PrintWriter outWriter=res.getWriter();
            outWriter.write(response);
            outWriter.flush();
        }catch(IOException e){
            logger.info(e);
            e.printStackTrace();
        }
    }
}
