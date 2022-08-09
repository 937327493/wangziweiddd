package com.wzw.wangziwei.ddd.domain.Log.model;

import com.alibaba.fastjson.JSONPath;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

@Getter
@Setter
/**
 * 一行日志记录有前有后，json形式
 */
public class LogAttrKeyOb {
    private String before;
    private String after;

    public Map<String, Pair<String, String>> diff(List<FieldDiffConfig> fieldDiffConfig) {
        Map<String, Pair<String, String>> hashMap = new HashMap();
        fieldDiffConfig.forEach(ict -> {
            String beforee = Optional.ofNullable(before)
                    .map(before -> JSONPath.extract(before, ict.getFieldPath()))
                    .map(Objects::toString)
                    .orElse(null);
            String afterr = Optional.ofNullable(after)
                    .map(after -> JSONPath.extract(after, ict.getFieldPath()))
                    .map(Objects::toString)
                    .orElse(null);
            if (!Objects.equals(beforee, afterr)) {
                hashMap.put(ict.getFieldName(), Pair.of(beforee, afterr));
            }
        });
        return hashMap;
    }
}
