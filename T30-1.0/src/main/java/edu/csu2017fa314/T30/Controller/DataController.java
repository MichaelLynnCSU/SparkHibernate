package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Itinerary.Data.DataService;
import org.apache.velocity.app.VelocityEngine;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static spark.Spark.get;
import static spark.Spark.post;

public class DataController {
    VelocityEngine ve;
    Properties props;
 //   DataService myModel;
    Gson gson;


    public DataController() {

        ve = new VelocityEngine();
        props = new Properties();
        props.put("file.resource.loader.path", "C:/Users/aplus/Documents/GitHub/JavaRestSP1/T30-1.0/src/main/java/edu/csu2017fa314/T30/View/");
        ve.init(props);
        gson = new Gson();
       // myModel = new DataService();

        post("/get", (request, response) -> {

           // Map<String, DataService> view = new HashMap<String, DataService>();
           // view.put("message", myModel);

            Map<String, String> view = new HashMap<String, String>();
             view.put("message", "Problem with data");
            return new VelocityTemplateEngine(ve).render(
                    new ModelAndView(view, "getdata.vm"));
        });


        post("/sort", (request, response) -> {
            System.out.println("datahere");
//            Map<String, DataService> view = new HashMap<String, DataService>();
//            view.put("message", myModel);
            Map<String, String> view = new HashMap<String, String>();
            view.put("message", "Problem with data");
            return new VelocityTemplateEngine(ve).render(
                    new ModelAndView(view, "data.vm"));
        });

        post("/search", (request, response) -> {
            System.out.println("datahere");
//            Map<String, DataService> view = new HashMap<String, DataService>();
//            view.put("message", myModel);
            Map<String, String> view = new HashMap<String, String>();
            view.put("message", "Problem with data");
            return new VelocityTemplateEngine(ve).render(
                    new ModelAndView(view, "search.vm"));
        });

    }
}
