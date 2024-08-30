package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : sourceMap.entrySet()) {
            String key = entry.getKey();
            int length = key.length();

            for(Map.Entry<String, Integer> entry2 : sourceMap.entrySet()) {
                if (length == entry2.getKey().length()) {
                    if (result.containsKey(length)) {
                        result.get(length).add(entry2.getKey());
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(entry2.getKey());
                        result.put(length, set);
                    }
                }
            }

        }

        return result;
    }
}
