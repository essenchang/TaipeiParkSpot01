package com.fishbowl.taipeiparkspot;

import java.util.List;

/**
 * Created by essenchang on 2017/1/21.
 */

public class ParkSpotResultDetailDTO {
    int offset;
    int limit;
    int count;
    String sort;
    List<ParkSpotItemDTO> results;
}
