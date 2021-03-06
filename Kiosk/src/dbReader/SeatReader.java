package dbReader;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class is a tool that can get seat status quickly.
 *
 * @author Zhang Zeyu
 * @author Liang Zhehao
 * @date 2022/2/21
 * @version 1.0
 */

public class SeatReader {

    int idPlane;
    String path;
    CsvReader csvReader;

    /**
     * @param idFlight the current flight id
     */
    public SeatReader(String idFlight) {
        idPlane = FlightReader.getIdPlane(FlightReader.indexOf(idFlight));
        path = "DB/planes/plane" + idPlane + ".csv";
    }

    /**
     * Get a row of seat status
     * @param row the row you want to get status of
     * @return an array contains seat status of that row. true: available; false: occupied
     */
    public boolean[] getSeat(int row) {
        try {
            csvReader = new CsvReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean[] seat = new boolean[6];
        for(int count = 0; count < row; count++) {
            try {
                csvReader.readRecord();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String[] record = csvReader.getRawRecord().split(",");
        for(int index = 0; index < 6; index++)
            seat[index] = record[index].equals("O");
        csvReader.close();
        return seat;
    }
}
