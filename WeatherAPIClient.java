import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPIClient {

    public static void main(String[] args) {
        try {
            // Public Weather API (No API key required)
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=13.0827&longitude=80.2707&current_weather=true";

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            // Display data in structured format
            System.out.println("Weather Data (JSON Format):");
            System.out.println("--------------------------------");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Error fetching weather data");
        }
    }
}
