package com.fishbowl.taipeiparkspot;


/**
 * Created by essenchang on 2017/1/21.
 */

public class ParkSpotItemDTO {
    String _id;
    String ParkName;
    String Name;
    String YearBuilt;
    String OpenTime;
    String Image;
    String Introduction;

    public void setTestData(int i) {
        _id = Integer.toString(i);
        ParkName = "ParkName:" + i;
        Name = "Name" + i;
    }

    @Override
    public String toString() {
        String s = ParkName + ", " + Name;
        return s;
    }
}
