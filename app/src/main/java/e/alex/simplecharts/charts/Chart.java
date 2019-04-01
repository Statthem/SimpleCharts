package e.alex.simplecharts.charts;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.ObjectStreamClass;
import java.util.stream.Stream;

public class Chart implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Column> columns;

    private Map<String, String> typesMap;
    private Map<String, String> namesMap;
    private Map<String, String> colorsMap;

    public Chart() {
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public Map<String, String> getTypesMap() {
        return typesMap;
    }

    public void setTypesMap(Map<String, String> typesMap) {
        this.typesMap = typesMap;
    }

    public Map<String, String> getNamesMap() {
        return namesMap;
    }

    public void setNamesMap(Map<String, String> namesMap) {
        this.namesMap = namesMap;
    }

    public Map<String, String> getColorsMap() {
        return colorsMap;
    }

    public void setColorsMap(Map<String, String> colorsMap) {
        this.colorsMap = colorsMap;
    }

    @Override
    public String toString() {
        return "[{'columns':" + columns.stream().map(column -> column.toString()).collect(Collectors.joining()) +
                ", typesMap=" + typesMap +
                ", namesMap=" + namesMap +
                ", colorsMap=" + colorsMap +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Chart)) return false;

        Chart other = (Chart) o;
        if(o == this) return true;

        if(!other.getColumns().equals(this.getColumns()))return false;
        if(!other.getColorsMap().equals(this.getColorsMap())) return false;
        if(!other.getTypesMap().equals(this.getTypesMap())) return false;
        if(!other.getNamesMap().equals(this.getNamesMap())) return false;
        else {
            return true;
        }
    }
    @Override
    public int hashCode(){
        int result = getColumns().stream().collect(Collectors.summingInt((column -> column.getLabel().hashCode())));
        List<Long> allValuesList = new ArrayList<>();
        getColumns().forEach((column -> column.getValues().forEach(value -> allValuesList.add(value))));

        result = result + (int) (allValuesList.stream().collect(Collectors.summingLong(value -> value))/1000);
        return (int) result;
    }



    public static class Column implements Serializable{

        private static final long serialVersionUID = 1L;

        public Column() {
        }

        String label;
        List<Long> values = new ArrayList<>(150);

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public List<Long> getValues() {
            return values;
        }

        public void setValues(List<Long> values) {
            this.values = values;
        }

        @Override
        public boolean equals(Object o) {
            if(o == null) return false;
            if(!(o instanceof Column)) return false;

            Column column = this;
            if(o == this) return true;

            if(!this.label.equals(((Column) o).label)) return false;
            if(!this.values.equals(((Column) o).values)) return false;
            else return true;
        }

        @Override
        public String toString() {

            String valuesStr = values.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(","));

            return "['" + label + "'," + valuesStr + "]";

        }
    }
}
