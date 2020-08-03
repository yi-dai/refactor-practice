package com.twu.refactoring;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        for(turnRightDirection e : turnRightDirection.values()){
            String temp = e.toString();
            if (direction == temp.charAt(0)){
                char finalDirection = e.getDirection();
                return new Direction(finalDirection);
            }
        }
        throw new IllegalArgumentException();
    }

    public Direction turnLeft() {

        for(turnLeftDirection e : turnLeftDirection.values()){
            String temp = e.toString();
            if (direction == temp.charAt(0)){
                char finalDirection = e.getDirection();
                return new Direction(finalDirection);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}

enum turnRightDirection {
    N('E'), S('W'), E('N'), W('S');
    private char resultDirection;
    private turnRightDirection(char resultDirection){
        this.resultDirection = resultDirection;
    }
    public char getDirection(){
        return resultDirection;
    }
}

enum turnLeftDirection {
    N('W'), S('E'), E('N'), W('S');
    private char resultDirection;
    private turnLeftDirection(char resultDirection){
        this.resultDirection = resultDirection;
    }
    public char getDirection(){
        return resultDirection;
    }
}