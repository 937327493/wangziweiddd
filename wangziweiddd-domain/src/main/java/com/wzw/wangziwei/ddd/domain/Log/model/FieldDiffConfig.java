package com.wzw.wangziwei.ddd.domain.Log.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldDiffConfig {
    private String fieldName;
    private String fieldPath;
    @Getter
    @Setter
    public static class FieldDiffOb {
        private List<FieldDiffConfig> fieldDiffConfigList;
        private FieldDiffOb() {
            this.fieldDiffConfigList = new ArrayList<>();
        }
        public FieldDiffOb builder() {
            return new FieldDiffOb();
        }
        public FieldDiffOb field(String name, String path) {
            this.fieldDiffConfigList.add(new FieldDiffConfig(name, path));
            return this;
        }
        public List<FieldDiffConfig> build() {
            return this.fieldDiffConfigList;
        }
    }
}
