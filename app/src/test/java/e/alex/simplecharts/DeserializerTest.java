package e.alex.simplecharts;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import e.alex.simplecharts.charts.Chart;
import e.alex.simplecharts.charts.Deserializer;
import e.alex.simplecharts.exceptions.IncorrectJsonException;
import e.alex.simplecharts.utils.IOUtils;

public class DeserializerTest {

    Chart chart;
    Deserializer deserializer;

    @Before
    public void init(){
        chart = new Chart();
        Chart.Column xColumn = new Chart.Column();
        xColumn.setLabel("x");
        Long[] xArray = {1542412800000L,1542499200000L,1542585600000L};
        xColumn.setValues(Arrays.asList(xArray));
        Chart.Column y0Column = new Chart.Column();
        y0Column.setLabel("y0");
        Long[] y0Array = {37L,20L,32L};
        y0Column.setValues(Arrays.asList(y0Array));
        Chart.Column y1Column = new Chart.Column();
        y1Column.setLabel("y1");;
        Long[] y1Array = {22L,12L,30L};
        y1Column.setValues(Arrays.asList(y1Array));
        chart.setColumns(Arrays.asList(new Chart.Column[]{xColumn,y0Column,y1Column}));

        Map<String,String> typesMap = new HashMap<>();
        typesMap.put("y0","line");
        typesMap.put("y1","line");
        typesMap.put("x","x");
        chart.setTypesMap(typesMap);
        Map<String,String> namesMap = new HashMap<>();
        namesMap.put("y0","#0");
        namesMap.put("y1","#1");
        chart.setNamesMap(namesMap);
        Map<String,String> colorsMap = new HashMap<>();
        colorsMap.put("y0","#3DC23F");
        colorsMap.put("y1","#F34C44");
        chart.setColorsMap(colorsMap);

        deserializer = new Deserializer();
    }

    @Test
    public void ifCorrectJsonAndSameValues_ThenEquals(){
        String  json = null;
        json = IOUtils.readJsonFromFile("src/main/res/raw/test_chart_data1.json");

        Chart parsedChart = (Chart)(deserializer.deserialize(json).get(0));
        Assert.assertEquals(chart, parsedChart);
}

    @Test
    public void ifCorrectJsonButWrongValues_ThenNotEquals(){
        String  json = null;
        json = IOUtils.readJsonFromFile("src/main/res/raw/test_chart_data2.json");

        Chart parsedChart = (Chart)(deserializer.deserialize(json).get(0));
        Assert.assertNotEquals(chart, parsedChart);
    }

    @Test(expected = IncorrectJsonException.class)
    public void ifIncorrectJson_ThenException(){
        String str =  null;
        String  json = null;
        json = IOUtils.readJsonFromFile("src/main/res/raw/test_chart_data3.json");

        Chart parsedChart = (Chart)(deserializer.deserialize(json));

    }

}
