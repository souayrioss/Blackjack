package org.example.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Cartes {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id ;
    private Types type;
    private Values value;

    public Cartes() {
        this.id = count.incrementAndGet();
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Values getValue() {
        return value;
    }

    public void setValue(Values value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + type +"  "+value + ")";
    }
}
