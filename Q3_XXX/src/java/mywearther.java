/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class mywearther {

    private static final String API_KEY = "8f8b40369bf4bf9785586244b7869cfd"; // Thay bằng API Key của bạn
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public String getweather() {

        String city = "Hanoi";
        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";

        try {
            // Gọi API
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Lỗi: HTTP " + conn.getResponseCode());
            }

            // Đọc dữ liệu từ API
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // Chuyển đổi JSON thành đối tượng
            JSONObject jsonResponse = new JSONObject(response.toString());
            double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
            String weatherDescription = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");

//            // Hiển thị kết quả
//            System.out.println("Thời tiết tại " + city + ":");
//            System.out.println("Nhiệt độ: " + temperature + "°C");
//            System.out.println("Mô tả: " + weatherDescription);

            return city + ": " + temperature+ "°C";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        mywearther s =  new mywearther();
          System.out.println(s.getweather());
    }
}
