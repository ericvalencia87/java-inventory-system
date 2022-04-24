package com.tesda.models;

import java.sql.Timestamp;

public class Product {

    //Fields
    private int product_id;
    private String product_name;
    private String uom;
    private int max_level;
    private int min_level;
    private int reorder_level;
    private String location;
    private boolean status;
    private java.sql.Timestamp date_created;
    private java.sql.Timestamp date_updated;

    public int getProduct_id() {
        return product_id;
    }

    public Product(int product_id, String product_name, String uom, int max_level,
                   int min_level, int reorder_level, String location, boolean status,
                   Timestamp date_created, Timestamp date_updated) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.uom = uom;
        this.max_level = max_level;
        this.min_level = min_level;
        this.reorder_level = reorder_level;
        this.location = location;
        this.status = status;
        this.date_created = date_created;
        this.date_updated = date_updated;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getUom() {
        return uom;
    }

    public int getMax_level() {
        return max_level;
    }

    public int getMin_level() {
        return min_level;
    }

    public int getReorder_level() {
        return reorder_level;
    }

    public String getLocation() {
        return location;
    }

    public boolean isStatus() {
        return status;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public Timestamp getDate_updated() {
        return date_updated;
    }
}
