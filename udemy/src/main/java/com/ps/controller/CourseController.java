package com.ps.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ps.domain.Course;
import com.ps.services.CourseService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = {"/courses"})
public class CourseController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(CourseController.class);
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try (InputStream iStream = req.getInputStream();
                JsonReader jsonReader = Json.createReader(iStream);) {
            JsonObject jsonObject = jsonReader.readObject();
            int id = jsonObject.getInt("id");
            String title = jsonObject.getString("title");
            String author = jsonObject.getString("author");
            String description = jsonObject.getString("description");
            String category = jsonObject.getString("category");
            String imageUrl = jsonObject.getString("imageurl");
            String lastUpdated = jsonObject.getString("lastupdated");
            float rating = Float.parseFloat(jsonObject.getString("rating"));
            long numberOfRatings = Long.parseLong(jsonObject.getString("numberofratings"));
            boolean isBestSeller = jsonObject.getBoolean("isbestseller");
            int originalPrice = jsonObject.getInt("originalprice");
            int discountPrice = jsonObject.getInt("discountprice");
            String level = jsonObject.getString("level");

            Course course = new Course(id, title, author, description, category, imageUrl, lastUpdated, rating,
                    numberOfRatings, isBestSeller, originalPrice, discountPrice, level);
            logger.info("course object created successfully from request body");
            CourseService courseService = new CourseService();
            Course course1 = courseService.createCourse(course);
            logger.info("the object returned from service"+course1);
            PrintWriter out=res.getWriter();
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");
            out.println("<html><head><title>test out</title></head><body>"+course1+"</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info(e);
        } catch (NamingException e) {
            e.printStackTrace();
            logger.info(e);
        }
    }
}
