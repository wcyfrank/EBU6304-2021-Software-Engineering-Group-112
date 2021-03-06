package dbReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * This class is a tool that can help you search and get values of plane info quickly.
 *
 * @author Zhang Zeyu
 * @date 2022/3/20
 * @version 1.0
 */

public abstract class PlaneReader {

    /**
     * Get index of given idPlane
     * @param idPlane primary key
     * @return index of that plane
     */
    public static int indexOf(int idPlane) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/plane.json"));
        JSONArray arr = obj.getJSONArray("plane");
        int index = 0;
        while(arr.getJSONObject(index).getInteger("idPlane") != idPlane) { index++; }
        return index;
    }

    public static String getModel(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/plane.json"));
        JSONArray arr = obj.getJSONArray("plane");
        return arr.getJSONObject(index).getString("model");
    }

    public static int getCapacity(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/plane.json"));
        JSONArray arr = obj.getJSONArray("plane");
        return arr.getJSONObject(index).getInteger("capacity");
    }

    public static String getAirline(int index) {
        JSONObject obj = JSON.parseObject(JsonReader.read("DB/plane.json"));
        JSONArray arr = obj.getJSONArray("plane");
        return arr.getJSONObject(index).getString("airline");
    }
}
