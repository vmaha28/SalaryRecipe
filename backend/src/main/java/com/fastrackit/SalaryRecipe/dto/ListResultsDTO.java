package com.fastrackit.SalaryRecipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListResultsDTO<K> {
    private List<K> results;
    private long totalRecords;

}
