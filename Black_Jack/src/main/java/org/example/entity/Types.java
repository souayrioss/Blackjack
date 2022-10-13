package org.example.entity;

public enum Types {
    CARREAU(1), COEUR(2), PIQUE(3),TREFLE(4) ;
    private int index;

    Types(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
