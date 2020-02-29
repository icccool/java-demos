package com.base.interfaces;

import java.util.List;

public class MessageQuery<T> extends Message {
    List<T> list;

    public MessageQuery(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
