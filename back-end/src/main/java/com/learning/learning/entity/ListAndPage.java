package com.learning.learning.entity;

import java.util.List;

/**
 * @author: Clivia-Han
 * @projectName: x-learning-system
 * @packageName: com.learning.learning.entity
 * @Description:
 * @create: 2021-04-26
 */
public class ListAndPage {
    int pageNum;
    long total;
    List<String> list;

    public ListAndPage(int pageNum, long total, List<String> list) {
        this.pageNum = pageNum;
        this.total = total;
        this.list = list;
    }

    public ListAndPage(){

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
