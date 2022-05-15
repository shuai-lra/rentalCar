package com.shuai.sys.vo;

import com.shuai.sys.domain.Menu;
import sun.awt.image.IntegerInterleavedRaster;

/**
 * 菜单视图对象
 */

public class MenuVo extends Menu {
    private Integer page;
    private Integer limit;

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
}
