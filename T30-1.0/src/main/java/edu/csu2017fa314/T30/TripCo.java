package edu.csu2017fa314.T30;
import edu.csu2017fa314.T30.Controller.DataController;
import edu.csu2017fa314.T30.Controller.JsonEffectController;
import edu.csu2017fa314.T30.Controller.LayoutController;
import edu.csu2017fa314.T30.Controller.UserController;
import edu.csu2017fa314.T30.Model.DataBase.DataBase;

import edu.csu2017fa314.T30.Model.Users.User.User;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import static spark.Spark.*;


public class TripCo
{


   private String name = "";

   public String getName()
   {
      return name;
   }

   public String getMessage()
   {
      if (name == "")
      {
         return "Hello!";
      }
      else
      {
         return "Hello " + name + "!";
      }
   }

   public void setName(String name)
   {
      this.name = name;
   }


   static int getHerokuAssignedPort() {
      ProcessBuilder processBuilder = new ProcessBuilder();
      if (processBuilder.environment().get("PORT") != null) {
         return Integer.parseInt(processBuilder.environment().get("PORT"));
      }
      return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
   }


   private static SessionFactory factory = null;

   public static void main(String[] args) throws SQLException {

      // Creating the config instance & passing the hibernate config file.
      Configuration config = new Configuration();
      config.configure("hibernate.cfg.xml");

      // Session object to start the db transaction.
      Session s = config.buildSessionFactory().openSession();

      // Transaction object to begin the db transaction.
      Transaction t = s.beginTransaction();


      User u1  = new User("Mike6", "Lynn6", "email16");
      // Saving the employee object to the db.
      s.save(u1);
      s.persist(u1);

      // Committing the transaction in the db.
      t.commit();

      System.out.println("\n===================\n");

      // Query - To fetch all employees.
      List<User> list = s.getNamedQuery("findUsers").getResultList();

      for(User emp : list) {
         System.out.println(emp.firstName);
      }

      // Closing the session object.
      s.close();
      //configure port
      port(getHerokuAssignedPort());
      get("/hello", (req, res) -> "Hello Heroku World");

      staticFileLocation("/public");

      DataBase db = new DataBase();
      db.myDataBase();
      new LayoutController();
      new UserController();
      new DataController();
      new JsonEffectController();
   }


}
