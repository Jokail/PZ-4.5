package org.example.entityTask;

public enum StoryPoints {
    ONE(1),
    TWO(2),
    THREE(3),
    FIFE(5),
    EIGHT(8),
    THIRTEEN(13),
    TWENTY(20),
    ONE_HUNDRED(100);
    private final int point;

    StoryPoints(int point) {
        this.point = point;
    }

    public int getPoint(){
        return point;
    }
}
