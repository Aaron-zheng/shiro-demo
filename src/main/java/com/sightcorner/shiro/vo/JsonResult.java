package com.sightcorner.shiro.vo;



public class JsonResult {

    public JsonResult(boolean isSuccess, Object data) {
        this.isSuccess = isSuccess;
        this.data = data;
    }

    private boolean isSuccess;

    private Object data;


    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
