package com.adekah.taskTrackerApp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TPage<T> {

    private int number;
    private int size;
    private int totalPages;
    private Sort sort;
    private Long totalElements;
    private List<T> content;

    public void setStat(Page page, List<T> list) {
        this.number = page.getNumber();
        this.size = page.getSize();
        this.sort = page.getSort();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.content = list;
    }
}
