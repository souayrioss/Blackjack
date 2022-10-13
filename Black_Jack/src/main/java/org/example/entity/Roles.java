package org.example.entity;

public enum Roles {
    DEALER(1),PLAYER(2);
    private int index;

    Roles(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
