package org.example.entity;

public enum Values {
    AS(1),DEUX(2),TROIS(3),QUATRE(4),CINQ(5),SIX(6),SEPT(7),HUIT(8),NEUF(9),DIX(10),VALET(10),DAME(10),ROI(10);
    private int index;

    Values(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
