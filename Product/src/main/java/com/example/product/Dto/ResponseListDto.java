package com.example.product.Dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseListDto<T> {
    Integer page;
    Integer perpage;
    List<T> data;
    long total;
    long numberPage;
    int begin;

    public Integer getPage() {
        return page;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(long numberPage) {
        this.numberPage = numberPage;
    }
}
