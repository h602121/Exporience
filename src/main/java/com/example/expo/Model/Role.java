package com.example.expo.Model;

public enum Role {
    SPECTATOR(1),
    EXHIBITOR(2),
    JURY(3);

    private final int i;

    Role(int i) {
        this.i = i;
    }

    public int getRoleID(){
        return this.i;
    }

}
