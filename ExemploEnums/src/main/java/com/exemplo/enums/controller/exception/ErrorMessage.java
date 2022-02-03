package com.exemplo.enums.controller.exception;

public class ErrorMessage {

    private String msg;
    private String path;
    private int status;
    private String error;
    private String method;

    public ErrorMessage() {
    }

    public ErrorMessage(String msg, String path, int status, String error, String method) {
        this.msg = msg;
        this.path = path;
        this.status = status;
        this.error = error;
        this.method = method;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
