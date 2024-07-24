package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

    // Method to insert a new student record into the database
    public static boolean insertStudentToDB(Student st) {
        boolean f = false;

        try {
            // Establishing a connection to the database
            Connection con = CP.createC();

            // SQL query with placeholders for parameters
            String q = "insert into students(sname,sphone,scity) value(?,?,?)";

            // PreparedStatement is used to execute parameterized queries
            PreparedStatement psmt = con.prepareStatement(q);

            // Setting values for the placeholders
            psmt.setString(1, st.getStudentName());
            psmt.setString(2, st.getStudentPhone());
            psmt.setString(3, st.getStudentCity());

            // executeUpdate() is used for DML (Data Manipulation Language) operations
            // such as INSERT, UPDATE, DELETE which modify the database
            psmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    // Method to delete a student record based on user ID
    public static boolean deleteStudent(int userId) {
        boolean f = false;
        try {
            // Establishing a connection to the database
            Connection con = CP.createC();

            // SQL query to delete a record based on a condition
            String q = "delete from students where sid=?";

            // PreparedStatement to set the condition for deletion
            PreparedStatement psmt = con.prepareStatement(q);

            // Setting the value for the placeholder
            psmt.setInt(1, userId);

            // executeUpdate() to execute the delete operation
            psmt.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean updateStudent(int userId, String name, String phone, String city) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "update students set sname=?, sphone=?, scity=? where sid=?";
            PreparedStatement psmt = con.prepareStatement(q);
            psmt.setString(1, name);
            psmt.setString(2, phone);
            psmt.setString(3, city);
            psmt.setInt(4, userId);
            psmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    // Method to display all student records from the database
    public static void showAllStudent() {
        try {
            // Establishing a connection to the database
            Connection con = CP.createC();

            // SQL query to select all records
            String q = "select * from students";

            // Statement is used for executing simple SQL queries without parameters
            Statement stmt = con.createStatement();

            // executeQuery() is used for retrieving data from the database
            // It returns a ResultSet which contains the data returned by the query
            ResultSet set = stmt.executeQuery(q);

            // Iterating over the ResultSet to display each record
            while (set.next()) {
                int id = set.getInt(1); // Retrieving the first column as an int
                String name = set.getString(2); // Retrieving the second column as a String
                String phone = set.getString(3); // Retrieving the third column as a String
                String city = set.getString("scity"); // Retrieving the column by column name

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone: " + phone);
                System.out.println("City: " + city);
                System.out.println("+++++++++++++++++");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
