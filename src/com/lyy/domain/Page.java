package com.lyy.domain;

import java.util.List;

/**
 * @description:page是分页的模型对象
 * @author: Moon
 */

public class Page<T> {

    public static final Integer PAGE_SIZE = 4;
    /**
     *当前页码
     */
    private Integer pageNo;
    /**
     * 总页码
     */
    private Integer pageTotal;
    /**
     * 当前页显示数量
     */
    private Integer pageSize = PAGE_SIZE;
    /**
     * 总记录数
     */
    private Integer getPageTotalCount;
    /**
     * 当前页数据
     */
    private List<T> items;

    private String url;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //设置有效边界
        if (pageNo < 1) {
            pageNo = 1;
        } else if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return getPageTotalCount;
    }

    public void setPageTotalCount(Integer getPageTotalCount) {
        this.getPageTotalCount = getPageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer getPageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.getPageTotalCount = getPageTotalCount;
        this.items = items;
    }

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", getPageTotalCount=" + getPageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
