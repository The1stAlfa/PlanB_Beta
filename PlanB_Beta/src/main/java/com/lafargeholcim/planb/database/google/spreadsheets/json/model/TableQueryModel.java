
package com.lafargeholcim.planb.database.google.spreadsheets.json.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class TableQueryModel {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("reqId")
    @Expose
    private String reqId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sig")
    @Expose
    private String sig;
    @SerializedName("table")
    @Expose
    private Table table;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TableQueryModel() {
    }

    /**
     * 
     * @param reqId
     * @param status
     * @param table
     * @param sig
     * @param version
     */
    public TableQueryModel(String version, String reqId, String status, String sig, Table table) {
        this.version = version;
        this.reqId = reqId;
        this.status = status;
        this.sig = sig;
        this.table = table;
    }

    /**
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The reqId
     */
    public String getReqId() {
        return reqId;
    }

    /**
     * 
     * @param reqId
     *     The reqId
     */
    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The sig
     */
    public String getSig() {
        return sig;
    }

    /**
     * 
     * @param sig
     *     The sig
     */
    public void setSig(String sig) {
        this.sig = sig;
    }

    /**
     * 
     * @return
     *     The table
     */
    public Table getTable() {
        return table;
    }

    /**
     * 
     * @param table
     *     The table
     */
    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
