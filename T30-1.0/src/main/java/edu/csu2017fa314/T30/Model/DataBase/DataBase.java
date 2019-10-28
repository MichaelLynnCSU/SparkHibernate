package edu.csu2017fa314.T30.Model.DataBase;

import edu.csu2017fa314.T30.Model.Users.User.User;

import java.sql.*;
import java.util.Properties;

public class DataBase {

    public DataBase()
    {

    }

    public void myDataBase() throws SQLException {

        Connection conn = null;
        ResultSet resultSet = null;

        // Create a variable for the connection strings.

        try {

            conn  = DriverManager.getConnection("jdbc:sqlserver://localhost:3306; integratedSecurity=true; database=LSI");
            Statement statement = conn.createStatement();

            if (conn != null) {
                System.out.println("Successfully connected to MySQL database test");
                // Create and execute a SELECT SQL statement.
                String selectSql = "SELECT Distinct Signal.[Signal], Signal.[Chart], Signal.[Block], Meas.[I/O name]\n" +
                        "From ([LSI].[DBO].[Nickajack_Plant_NJH_CH_AI_Signa$] AS Signal\n" +
                        "INNER JOIN [LSI].[DBO].[Nickajack_Plant_NJH_CH_AI_Range$] AS Ranges \n" +
                        "ON Signal.[Chart] = Ranges.[Chart] AND Signal.[Block] = Ranges.[Block]\n" +
                        "INNER JOIN [LSI].[DBO].[Nickajack_Plant_NJH_CH_AI_Bridg$] AS Bridge \n" +
                        "ON Bridge.[Chart] = Ranges.[Chart] AND Bridge.[nBlock] = Ranges.[nBlock]\n" +
                        "INNER JOIN [LSI].[DBO].[Nickajack_Plant_NJH_CH_AI_Meas_$] AS Meas \n" +
                        "ON Bridge.[Chart] = Meas.[Chart] AND Bridge.[nBlock] = Meas.[Block])";

               // executeQuery method execute statements that returns a result set by fetching some data from the database. It executes only select statements.
                resultSet = statement.executeQuery(selectSql);

                // Print results from select statement
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                }

            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
        }

        }

    public void myUserDataBase(User myUsers) throws SQLException {

        Connection conn = null;
        int resultSet;

        // Create a variable for the connection string.

        try {

            conn  = DriverManager.getConnection("jdbc:sqlserver://localhost:3306; integratedSecurity=true; database=Users");
            Statement statement = conn.createStatement();

            if (conn != null) {
                System.out.println("Successfully connected to MySQL database test");
                System.out.println( "data input" + myUsers.firstName  + myUsers.lastName + myUsers.email);
                // Create and execute a SELECT SQL statement.
                myUsers.firstName = "\'" + myUsers.firstName + "\'";
                myUsers.lastName = "\'" + myUsers.lastName + "\'";
                myUsers.email = "\'" + myUsers.email + "\'";

                String selectSql = "insert into ExampleUsers (ExampleUsers.[firstName], ExampleUsers.[lastName], ExampleUsers.[email])\n" +
                        "                   values ("+ myUsers.firstName +", "+ myUsers.lastName +", "+ myUsers.email +")";

                System.out.println(selectSql);
               // executeUpdate method execute sql statements that insert/update/delete data at the database.
               // This method return int value representing number of records affected; Returns 0 if the query returns nothing. The method accepts only non-select statements.
                resultSet = statement.executeUpdate(selectSql);
                System.out.println(resultSet);

            }
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
        }

    }

}

