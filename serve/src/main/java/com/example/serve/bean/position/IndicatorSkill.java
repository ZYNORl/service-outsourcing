package com.example.serve.bean.position;


public class IndicatorSkill {
    private String name;
    private Integer max;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"max\":")
                .append(max);
        sb.append('}');
        return sb.toString();
    }
}
