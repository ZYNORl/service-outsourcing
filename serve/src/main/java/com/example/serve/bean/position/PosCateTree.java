package com.example.serve.bean.position;

import java.util.List;

public class PosCateTree {
    private String name;
    private List<PosCateTree> children;

    public PosCateTree() {
    }

    public PosCateTree(String name, List<PosCateTree> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PosCateTree> getChildren() {
        return children;
    }

    public void setChildren(List<PosCateTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"children\":")
                .append(children);
        sb.append('}');
        return sb.toString();
    }
}
