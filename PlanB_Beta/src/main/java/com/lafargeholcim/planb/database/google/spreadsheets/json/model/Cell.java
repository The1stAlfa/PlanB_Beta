
package com.lafargeholcim.planb.database.google.spreadsheets.json.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Cell {

    @SerializedName("v")
    @Expose
    private String v;
    @SerializedName("f")
    @Expose
    private String f;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cell() {
    }

    /**
     * 
     * @param f
     * @param v
     */
    public Cell(String v, String f) {
        this.v = v;
        this.f = f;
    }

    /**
     * 
     * @return
     *     The v
     */
    public String getV() {
        return v;
    }

    /**
     * 
     * @param v
     *     The v
     */
    public void setV(String v) {
        this.v = v;
    }

    /**
     * 
     * @return
     *     The f
     */
    public String getF() {
        return f;
    }

    /**
     * 
     * @param f
     *     The f
     */
    public void setF(String f) {
        this.f = f;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
