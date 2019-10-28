package edu.csu2017fa314.T30.Controller;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Itinerary.Data.DataService;
import org.apache.velocity.app.VelocityEngine;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static spark.Spark.*;

public class LayoutController {

    VelocityEngine ve;
    Properties props;
    DataService myModel;
    Gson gson;


    public LayoutController() {


        ve = new VelocityEngine();
        props = new Properties();
        props.put("file.resource.loader.path", "C:/Users/aplus/Documents/GitHub/JavaRestSP1/T30-1.0/src/main/java/edu/csu2017fa314/T30/View/");
        ve.init(props);

      //  myModel = new DataService();
        gson = new Gson();

        get("/layout", (request, response) -> {
            Map<String, String> view = new HashMap<String, String>();
            view.put("message", "Select Data");
            return new VelocityTemplateEngine(ve).render(
                    new ModelAndView(view, "template/layout.vm"));

        });

    }




}
