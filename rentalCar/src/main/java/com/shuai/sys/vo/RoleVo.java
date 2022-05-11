package com.shuai.sys.vo;

import com.shuai.sys.domain.Role;

public class RoleVo extends Role {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    //接收多个角色id
    private Integer[] ids;

    public RoleVo() {
    }

    public RoleVo(Integer page) {
        this.page = page;
    }

    public RoleVo(Integer roleid, String rolename, String roledesc, Integer available, Integer page) {
        super(roleid, rolename, roledesc, available);
        this.page = page;
    }

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

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}
