package com.shuai.sys.vo;

import com.shuai.sys.domain.LogInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LogInfoVo extends LogInfo {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    /**
     * 扩展表单的参数
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Integer[] ids;

    public LogInfoVo() {
    }

    public LogInfoVo(Integer page, Integer limit, Date startTime, Date endTime) {
        this.page = page;
        this.limit = limit;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public LogInfoVo(Integer id, String loginname, String loginip, Date logintime, Integer page, Integer limit, Date startTime, Date endTime) {
        super(id, loginname, loginip, logintime);
        this.page = page;
        this.limit = limit;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
