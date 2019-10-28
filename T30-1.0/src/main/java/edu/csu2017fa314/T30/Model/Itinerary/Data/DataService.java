package edu.csu2017fa314.T30.Model.Itinerary.Data;

import com.google.gson.Gson;
import edu.csu2017fa314.T30.Model.Itinerary.BaseCRUD;

import java.util.Arrays;

public class DataService extends BaseCRUD {

    public String[][] data;
    Data myModel;
    Gson gson;

    public DataService()
    {
        data = new String[3][];
        myModel = new Data();
        myModel.readData();
        data = myModel.buildItinerary();
        gson = new Gson();
    }

    @Override
    public String getAllData() {
        // Convert Java objects to JSON
        String json = gson.toJson(data);
        System.out.println(json);
        return json;
    }

    @Override
    public String search(String searchVal) {
        String[] result = new String[3];

        // get single object entry
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(searchVal)) {
                result = Arrays.copyOf(data[i], 3);
            }
        }
        String test = gson.toJson(result);
        System.out.println(test);
     return test;
    }

    @Override
    public String sort(String searchVal) {
        String[] result = new String[3];

        // get single object entry
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(searchVal)) {
                result = Arrays.copyOf(data[i], 3);
            }
        }
        Arrays.sort(result);
        String test = gson.toJson(result);
        System.out.println(test);
        return test;
    }

}
