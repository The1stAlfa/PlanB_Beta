
package com.lafargeholcim.planb.database.google.spreadsheets.json.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Row {

    @SerializedName("c")
    @Expose
    private List<Cell> c = new ArrayList<Cell>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Row() {
    }

    /**
     * 
     * @param c
     */
    public Row(List<Cell> c) {
        this.c = c;
    }

    /**
     * 
     * @return
     *     The c
     */
    public List<Cell> getC() {
        return c;
    }

    /**
     * 
     * @param c
     *     The c
     */
    public void setC(List<Cell> c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
