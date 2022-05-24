package com.example.serve.bean.user;

public class userLogin {
    private Integer useId;
    private Integer status;
    private String message;
    public userLogin(){

    }

    public userLogin(Integer useId, Integer status, String message) {
        this.useId = useId;
        this.status = status;
        this.message = message;
    }

    public Integer getUseId() {
        return useId;
    }

    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"useId\":")
                .append(useId);
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"message\":\"")
                .append(message).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
