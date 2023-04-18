package com.example.expo.util;

import java.util.HashMap;
import java.util.Map;

public class GeneralFormatUtil {

    public static Map<String, Integer> validNumberFormat(HashMap<String, String> map) {
        Integer content_presentation = null;
        Integer rating_presentation = null;
        Integer poster_presentation = null;

        try {
            content_presentation = Integer.parseInt(map.get("content_presentation"));
        } catch (NumberFormatException e) {
        }
        try {
            rating_presentation = Integer.parseInt(map.get("rating_presentation"));
        } catch (NumberFormatException e) {
        }
        try {
            poster_presentation = Integer.parseInt(map.get("poster_presentation"));
        } catch (NumberFormatException e) {
        }

        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("content_presentation", content_presentation);
        newMap.put("rating_presentation", rating_presentation);
        newMap.put("poster_presentation", poster_presentation);
        return newMap;
    }
}
