package com.shuai.bus.vo;

import com.shuai.bus.domain.Customer;

/**
 * 客户视图对象
 */
public class CustomerVo extends Customer {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    //接收多少个id
    private String[] ids;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
