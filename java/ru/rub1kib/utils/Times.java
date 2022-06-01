package ru.rub1kib.utils;

public class Times {
    public static final int getTime(int h){
        if(h > 6){
            return h * 1000 - 6000;
        } else if(h == 0) {
            return 18000;
        } else if(h == 1){
            return 19000;
        } else if(h == 2){
            return 20000;
        } else if(h == 3){
            return 21000;
        } else if(h == 4){
            return 22000;
        } else if(h == 5){
            return 23000;
        } else if(h == 6){
            return 24000;
        }
        return 6000;
    }
}
