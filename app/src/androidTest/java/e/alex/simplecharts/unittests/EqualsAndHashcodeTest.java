package e.alex.simplecharts.unittests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import e.alex.simplecharts.charts.Chart;

import static org.hamcrest.Matchers.equalTo;

public class EqualsAndHashcodeTest {

    Chart chart1;
    Chart chart2;
    Chart chart3;

    @Before
    public void init() {
        chart1 = new Chart();
        Chart.Column xColumn = new Chart.Column();
        xColumn.setLabel("x1");
        Long[] xArray = {1542412800000L, 1542499200000L, 1542585600000L};
        xColumn.setValues(Arrays.asList(xArray));
        Chart.Column y0Column = new Chart.Column();
        y0Column.setLabel("y0");
        Long[] y0Array = {37L, 20L, 32L};
        y0Column.setValues(Arrays.asList(y0Array));
        Chart.Column y1Column = new Chart.Column();
        y1Column.setLabel("y1");
        Long[] y1Array = {22L, 12L, 30L};
        y1Column.setValues(Arrays.asList(y1Array));
        chart1.setColumns(Arrays.asList(new Chart.Column[]{xColumn, y0Column, y1Column}));

        Map<String, String> typesMap = new HashMap<>();
        typesMap.put("y0", "line");
        typesMap.put("y1", "line");
        typesMap.put("x", "x");
        chart1.setTypesMap(typesMap);
        Map<String, String> namesMap = new HashMap<>();
        namesMap.put("y0", "#0");
        namesMap.put("y1", "#1");
        chart1.setNamesMap(namesMap);
        Map<String, String> colorsMap = new HashMap<>();
        colorsMap.put("y0", "#3DC23F");
        colorsMap.put("y1", "#F34C44");
        chart1.setColorsMap(colorsMap);

        chart2 = new Chart();
        Chart.Column xColumn2 = new Chart.Column();
        xColumn2.setLabel("x1");
        Long[] xArray2 = {1542412800000L, 1542499200000L, 1542585600000L};
        xColumn2.setValues(Arrays.asList(xArray2));
        Chart.Column y0Column2 = new Chart.Column();
        y0Column2.setLabel("y0");
        Long[] y0Array2 = {37L, 20L, 32L};
        y0Column2.setValues(Arrays.asList(y0Array2));
        Chart.Column y1Column2 = new Chart.Column();
        y1Column2.setLabel("y1");
        ;
        Long[] y1Array2 = {22L, 12L, 30L};
        y1Column2.setValues(Arrays.asList(y1Array2));
        chart2.setColumns(Arrays.asList(new Chart.Column[]{xColumn, y0Column, y1Column}));

        Map<String, String> typesMap2 = new HashMap<>();
        typesMap2.put("y0", "line");
        typesMap2.put("y1", "line");
        typesMap2.put("x", "x");
        chart2.setTypesMap(typesMap2);
        Map<String, String> namesMap2 = new HashMap<>();
        namesMap2.put("y0", "#0");
        namesMap2.put("y1", "#1");
        chart2.setNamesMap(namesMap2);
        Map<String, String> colorsMap2 = new HashMap<>();
        colorsMap2.put("y0", "#3DC23F");
        colorsMap2.put("y1", "#F34C44");
        chart2.setColorsMap(colorsMap2);

        chart3 = new Chart();
        chart3.setColumns(Arrays.asList(new Chart.Column[]{y0Column, y1Column}));
        chart3.setColorsMap(colorsMap);
        chart3.setNamesMap(namesMap);
        chart3.setTypesMap(typesMap);
    }


    @Test
    public void equalObjects_equals_returnTrue() {
        Assert.assertThat(chart1, equalTo(chart2));
    }

    @Test
    public void unequalObjects_equals_returnFalse() {
        Assert.assertTrue(!chart1.equals(chart3));
    }

    @Test
    public void equalObjects_hashCode_same(){
        Assert.assertThat(chart1.hashCode(), equalTo(chart2.hashCode()));
    }

    @Test
    public void unequalObjects_hashCode_notSame(){
        Assert.assertTrue(chart1.hashCode() != chart3.hashCode());
    }

}
