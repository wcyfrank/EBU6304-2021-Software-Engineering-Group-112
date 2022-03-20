package dbReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * This class is a tool that can help you search and get values of flight info quickly.
 *
 * @author Zhang Zeyu
 * @date 2022/3/20
 * @version 1.0
 */

public abstract class FlightReader {

    /**
     * Get index of given idFlight
     * @param idFlight primary key
     * @return index of that flight
     */
    public static int indexOf(String idFlight) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/flight.json"));
        JSONArray arr = obj.getJSONArray("flight");
        int index = 0;
        while(!arr.getJSONObject(index).getString("idFlight").equals(idFlight)) { index++; }
        return index;
    }

    public static String getDeparture(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/flight.json"));
        JSONArray arr = obj.getJSONArray("flight");
        return arr.getJSONObject(index).getString("departure");
    }

    public static String getArrival(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/flight.json"));
        JSONArray arr = obj.getJSONArray("flight");
        return arr.getJSONObject(index).getString("arrival");
    }

    public static String getGate(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/flight.json"));
        JSONArray arr = obj.getJSONArray("flight");
        return arr.getJSONObject(index).getString("gate");
    }

    public static String getDepartureTime(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/flight.json"));
        JSONArray arr = obj.getJSONArray("flight");
        return arr.getJSONObject(index).getString("departureTime");
    }

    public static String getArrivalTime(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/flight.json"));
        JSONArray arr = obj.getJSONArray("flight");
        return arr.getJSONObject(index).getString("arrivalTime");
    }

    public static String getBoardingTime(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/flight.json"));
        JSONArray arr = obj.getJSONArray("flight");
        return arr.getJSONObject(index).getString("boardingTime");
    }

    public static int getIdPlane(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/flight.json"));
        JSONArray arr = obj.getJSONArray("flight");
        return arr.getJSONObject(index).getInteger("idPlane");
    }
}
