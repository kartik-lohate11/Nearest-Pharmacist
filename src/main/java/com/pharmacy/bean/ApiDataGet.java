package com.pharmacy.bean;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApiDataGet {
    private long distance,duration;
    private String printStatus;


    public void SolveApi(String src,String des){
        try {
//            String orgin = "23.2889632,77.3948103",destination="23.2972745,77.3437572";
            String orgin = src,destination = des;
            String apiKey="b98e9dd2f9414231bae19340b76feff0";
            URL url = new URL("https://api.nextbillion.io/distancematrix/json?origins=" + orgin + "&destinations=" + destination + "&mode=4w&key=" + apiKey);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("API Response: " + response.toString());

            connection.disconnect();
            fatcjJsonData(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fatcjJsonData(String response) {
        String jsonData = response;
        try {
            JSONParser jsonParser = new JSONParser();
            Object objArray = jsonParser.parse(response);
            JSONObject jsonObject = (JSONObject) objArray;

            JSONArray jsonArray = (JSONArray) jsonObject.get("rows");
            System.out.println(jsonArray);

            for(Object object:jsonArray){
                JSONObject rows = (JSONObject) object;
                JSONArray rowArray = (JSONArray) rows.get("elements");
                for(Object element:rowArray){
                    JSONObject elm = (JSONObject) element;
                    JSONObject duration = (JSONObject) elm.get("duration");
                    JSONObject distance = (JSONObject) elm.get("distance");

                    long durationVal = (long) duration.get("value");
                    long distanceVal = (long) distance.get("value");

                    setDistance(distanceVal);
                    setDuration(durationVal);

                    System.out.println("Duration = "+durationVal+" and Distance = "+distanceVal+" Km");
                    converTimeandDistance(durationVal,distanceVal);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void converTimeandDistance(long durationVal, long distanceVal) {
        long hours = TimeUnit.SECONDS.toHours(durationVal);
        long min = TimeUnit.SECONDS.toMinutes(durationVal)%60;
        long sec = durationVal%60;

        String actualDura = String.format("%02d:%02d:%02d",hours,min,sec);
        System.out.println("Actual time = "+actualDura);

        String actualDis = (distanceVal>999)?(distanceVal/1000.0)+"Km":distanceVal+"m";
        System.out.println("Actual Distance = "+actualDis);

        setPrintStatus(actualDis+" and "+actualDura);

    }

    public void setDistance(long distance){
        this.distance = distance;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public long getDistance() {
        return distance;
    }

    public String getPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(String printStatus) {
        this.printStatus = printStatus;
    }
}
