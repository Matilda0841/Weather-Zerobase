package zerobase.weather.Service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import zerobase.weather.Domain.Dairy;
import zerobase.weather.Repository.DairyRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class DairyService {

  private final DairyRepository dairyRepository;
  @Value("${openWeatherMap.key}")
  private String APIKEY;

  public DairyService(DairyRepository dairyRepository) {
    this.dairyRepository = dairyRepository;
  }

  public void createDiary(LocalDate date, String text) {
    String weatherData = getWeatherString();

    Map<String, Object> parseWeather = parseWeather(weatherData);

    Dairy nowDairy = new Dairy();
    nowDairy.setWeather(parseWeather.get("main").toString());
    nowDairy.setIcon(parseWeather.get("icon").toString());
    nowDairy.setTemperature((Double) parseWeather.get("temp"));
    nowDairy.setText(text);
    nowDairy.setDate(date);
    dairyRepository.save(nowDairy);

  }

  private String getWeatherString() {
    String apiUrl = "https://api.openweathermap.org/data/2.5/weather?" +
        "q=seoul&appid=" + APIKEY;
//    System.out.println(apiUrl);
    try {
      URL url = new URL(apiUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      int responseCode = connection.getResponseCode();
      BufferedReader br;
      if (responseCode == 200) {
        br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      } else {
        br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      }
      String inputLine;
      StringBuilder response = new StringBuilder();
      while ((inputLine = br.readLine()) != null) {
        response.append(inputLine);
      }

      return response.toString();
    } catch (Exception e) {
      return "응답에 받아 오는 것에 실패 했습니다.";
    }

  }

  private Map<String, Object> parseWeather(String jsonString) {
    JSONParser jsonParser = new JSONParser();
    JSONObject jsonObject;

    try {
      jsonObject = (JSONObject) jsonParser.parse(jsonString);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }

    Map<String, Object> resultMap = new HashMap<>();
    JSONObject mainData = (JSONObject) jsonObject.get("main");
    resultMap.put("temp", mainData.get("temp"));
    JSONArray weatherArray = (JSONArray) jsonObject.get("weather");
    JSONObject weatherData = (JSONObject) weatherArray.get(0);
    resultMap.put("main", mainData.get("main"));
    resultMap.put("icon", mainData.get("icon"));
    return resultMap;

  }
}
