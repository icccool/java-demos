package com.base.interfaces;

public class MessageData<T> extends Message {

    T data;

    public MessageData(boolean b ,T data) {
        this.data = data;
        this.success = b;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
