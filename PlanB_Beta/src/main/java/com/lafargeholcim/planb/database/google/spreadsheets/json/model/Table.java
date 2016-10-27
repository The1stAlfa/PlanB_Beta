
package com.lafargeholcim.planb.database.google.spreadsheets.json.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Table {

    @SerializedName("cols")
    @Expose
    private List<Column> cols = new ArrayList<Column>();
    @SerializedName("rows")
    @Expose
    private List<Row> rows = new ArrayList<Row>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Table() {
    }

    /**
     * 
     * @param cols
     * @param rows
     */
    public Table(List<Column> cols, List<Row> rows) {
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * 
     * @return
     *     The cols
     */
    public List<Column> getCols() {
        return cols;
    }

    /**
     * 
     * @param cols
     *     The cols
     */
    public void setCols(List<Column> cols) {
        this.cols = cols;
    }

    /**
     * 
     * @return
     *     The rows
     */
    public List<Row> getRows() {
        return rows;
    }

    /**
     * 
     * @param rows
     *     The rows
     */
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
