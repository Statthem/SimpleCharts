package e.alex.simplecharts.charts;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import e.alex.simplecharts.exceptions.IncorrectJsonException;

public class Deserializer {


    //changed for task specific case
    /*
    public List<Chart> deserialize (String json){

        List<Chart> chartList = new ArrayList<>();

        try {
            JSONArray mainArray = new JSONArray(json);

            for (int i = 0; i < mainArray.length(); i++) {
                JSONObject chartObject = mainArray.getJSONObject(i);
                JSONArray columns = chartObject.getJSONArray("columns");
                Chart chart = new Chart();
                List<Chart.Column> columnsList = new ArrayList<>();

                for (int j = 0; j < columns.length(); j++) {
                    Chart.Column column = new Chart.Column();
                    List<Long> valuesList = new ArrayList<>();
                    JSONArray values = columns.getJSONArray(j);

                    for (int k = 0; k < values.length(); k++) {
                        if (k == 0) column.setLabel(values.getString(k));
                        else
                            valuesList.add(values.getLong(k));
                    }
                    column.setValues(valuesList);
                    columnsList.add(column);
                }

                Map<String, String> typesMap;
                Map<String, String> namesMap;
                Map<String, String> colorsMap;

                if (i == mainArray.length() - 1) {
                    typesMap = new HashMap<>();
                    typesMap.put("y0", chartObject.getJSONObject("types").getString("y0"));
                    typesMap.put("y1", chartObject.getJSONObject("types").getString("y1"));
                    typesMap.put("y2", chartObject.getJSONObject("types").getString("y2"));
                    typesMap.put("y3", chartObject.getJSONObject("types").getString("y3"));
                    typesMap.put("x", chartObject.getJSONObject("types").getString("x"));

                    namesMap = new HashMap<>();
                    namesMap.put("y0", chartObject.getJSONObject("names").getString("y0"));
                    namesMap.put("y1", chartObject.getJSONObject("names").getString("y1"));
                    namesMap.put("y2", chartObject.getJSONObject("names").getString("y2"));
                    namesMap.put("y3", chartObject.getJSONObject("names").getString("y3"));

                    colorsMap = new HashMap<>();
                    colorsMap.put("y0", chartObject.getJSONObject("colors").getString("y0"));
                    colorsMap.put("y1", chartObject.getJSONObject("colors").getString("y1"));
                    colorsMap.put("y2", chartObject.getJSONObject("colors").getString("y2"));
                    colorsMap.put("y3", chartObject.getJSONObject("colors").getString("y3"));
                } else {
                    typesMap = new HashMap<>();
                    typesMap.put("y0", chartObject.getJSONObject("types").getString("y0"));
                    typesMap.put("y1", chartObject.getJSONObject("types").getString("y1"));
                    typesMap.put("x", chartObject.getJSONObject("types").getString("x"));

                    namesMap = new HashMap<>();
                    namesMap.put("y0", chartObject.getJSONObject("names").getString("y0"));
                    namesMap.put("y1", chartObject.getJSONObject("names").getString("y1"));

                    colorsMap = new HashMap<>();
                    colorsMap.put("y0", chartObject.getJSONObject("colors").getString("y0"));
                    colorsMap.put("y1", chartObject.getJSONObject("colors").getString("y1"));

                }
                chart.setColumns(columnsList);

                chart.setTypesMap(typesMap);
                chart.setNamesMap(namesMap);
                chart.setColorsMap(colorsMap);

                chartList.add(chart);
            }

            return chartList;

        }catch (JSONException exc){
            exc.printStackTrace();
        } finally {
            return chartList;
        }
    }
    */

    public List<Chart> deserialize (String json){

        List<Chart> chartList = new ArrayList<>();

        try {
            JSONArray mainArray = new JSONArray(json);

            for (int i = 0; i < mainArray.length(); i++) {
                JSONObject chartObject = mainArray.getJSONObject(i);
                JSONArray columns = chartObject.getJSONArray("columns");
                Chart chart = new Chart();
                List<Chart.Column> columnsList = new ArrayList<>();

                for (int j = 0; j < columns.length(); j++) {
                    Chart.Column column = new Chart.Column();
                    List<Long> valuesList = new ArrayList<>();
                    JSONArray values = columns.getJSONArray(j);

                    for (int k = 0; k < values.length(); k++) {
                        if (k == 0) column.setLabel(values.getString(k));
                        else
                            valuesList.add(values.getLong(k));
                    }
                    column.setValues(valuesList);
                    columnsList.add(column);
                }

                Map<String, String> typesMap;
                Map<String, String> namesMap;
                Map<String, String> colorsMap;

                    typesMap = new HashMap<>();
                    typesMap.put("y0", chartObject.getJSONObject("types").getString("y0"));
                    typesMap.put("y1", chartObject.getJSONObject("types").getString("y1"));
                    typesMap.put("x", chartObject.getJSONObject("types").getString("x"));

                    namesMap = new HashMap<>();
                    namesMap.put("y0", chartObject.getJSONObject("names").getString("y0"));
                    namesMap.put("y1", chartObject.getJSONObject("names").getString("y1"));

                    colorsMap = new HashMap<>();
                    colorsMap.put("y0", chartObject.getJSONObject("colors").getString("y0"));
                    colorsMap.put("y1", chartObject.getJSONObject("colors").getString("y1"));


                chart.setColumns(columnsList);

                chart.setTypesMap(typesMap);
                chart.setNamesMap(namesMap);
                chart.setColorsMap(colorsMap);

                chartList.add(chart);
            }

            return chartList;

        }catch (JSONException exc){
            exc.printStackTrace();

            throw new IncorrectJsonException("incorrect json file provided");
        } finally {
            return chartList;
        }
    }

}
