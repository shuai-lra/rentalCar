package com.shuai.sys.vo;

import com.shuai.sys.domain.User;

/**
 * 用户视图对象,包含分页字段
 */
public class UserVo extends User {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;
    private String code;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    /**
     * 接收多个角色的id
     */
    private Integer[] ids;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
