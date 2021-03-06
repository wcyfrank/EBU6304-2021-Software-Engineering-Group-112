package dbReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a tool that can help you search and get values of passenger's flight info quickly.
 *
 * @author Zhang Zeyu
 * @date 2022/3/20
 * @version 1.0
 */

public abstract class PassengerFlightReader {

    /**
     * Get index of given idPassengerFlight.
     * @param idPassengerFlight primary key
     * @return index of that passengerFlight
     */
    public static int indexOf(int idPassengerFlight) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        int index = 0;
        while(arr.getJSONObject(index).getInteger("idPassengerFlight") != idPassengerFlight) { index++; }
        return index;
    }

    /**
     * Get a list of idFlight of a given bookingNum.
     * @param bookingNum the booking number of that passenger
     * @return a list that contains flight ids that bookingNum matches
     */
    public static List<String> indexOfBooking(String bookingNum) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        List<String> list = new ArrayList<>();
        for(int index = 0; index < arr.size(); index++) {
            if(arr.getJSONObject(index).getString("bookingNum").equals(bookingNum))
                list.add(arr.getJSONObject(index).getString("idFlight"));
        }
        return list;
    }

    public static String getIdPassenger(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        return arr.getJSONObject(index).getString("idPassenger");
    }

    public static String getIdFlight(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        return arr.getJSONObject(index).getString("idFlight");
    }

    public static String getBookingNum(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        return arr.getJSONObject(index).getString("bookingNum");
    }

    public static int getCarryon(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        return arr.getJSONObject(index).getInteger("carryon");
    }

    public static int getCheckin(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        return arr.getJSONObject(index).getInteger("checkin");
    }

    public static int getBagDropCounter(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        return arr.getJSONObject(index).getInteger("bagDropCounter");
    }

    public static boolean getStatus(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/passengerFlight.json"));
        JSONArray arr = obj.getJSONArray("passengerFlight");
        return arr.getJSONObject(index).getBoolean("status");
    }
}
