package com.example.crud_example.Model;


import java.util.List;

public class ResponseData {
    private int status;
    private String message;
    private List<ModelData> data; // ambil list dari ModelData beri nama data

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ModelData> getData() {
        return data;
    }

    public void setData(List<ModelData> data) {
        this.data = data;
    }
}
