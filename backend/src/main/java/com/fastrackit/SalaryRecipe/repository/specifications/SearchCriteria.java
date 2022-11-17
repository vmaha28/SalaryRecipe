package com.fastrackit.SalaryRecipe.repository.specifications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    private boolean orPredicate;

    public boolean isOrPredicate() {
        return orPredicate;
    }
}
