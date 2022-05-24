package com.example.serve.bean.position;

import java.util.List;

public class PosCate {
    private Integer pos_id;
    private String pos_name;
    private Integer pos_level;
    private Integer pos_pid;
    private List<PosCate> children;

    public PosCate() {
    }

    public PosCate(Integer pos_id, String pos_name, Integer pos_level, Integer pos_pid, List<PosCate> children) {
        this.pos_id = pos_id;
        this.pos_name = pos_name;
        this.pos_level = pos_level;
        this.pos_pid = pos_pid;
        this.children = children;
    }

    public Integer getPos_id() {
        return pos_id;
    }

    public void setPos_id(Integer pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public Integer getPos_level() {
        return pos_level;
    }

    public void setPos_level(Integer pos_level) {
        this.pos_level = pos_level;
    }

    public Integer getPos_pid() {
        return pos_pid;
    }

    public void setPos_pid(Integer pos_pid) {
        this.pos_pid = pos_pid;
    }

    public List<PosCate> getChildren() {
        return children;
    }

    public void setChildren(List<PosCate> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"pos_id\":")
                .append(pos_id);
        sb.append(",\"pos_name\":\"")
                .append(pos_name).append('\"');
        sb.append(",\"pos_level\":")
                .append(pos_level);
        sb.append(",\"pos_pid\":")
                .append(pos_pid);
        sb.append(",\"children\":")
                .append(children);
        sb.append('}');
        return sb.toString();
    }
}
