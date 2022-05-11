package com.shuai.sys.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 树节点对象
 * 将menu的信息按照树状有层次的结构展示
 */
public class TreeNode {
    private Integer id;
    @JsonProperty("parentId")
    private Integer pid;
    private String title;
    private String icon;
    private String href;
    private boolean spread; //true展开  false关闭
    private String target;

    private List<TreeNode> children = new ArrayList<>();
    //复选框树也是必要的
    private String checkArr = "0"; // 如果复选框被勾选值是1  如果没有被勾选是0

    public TreeNode(Integer id, Integer pid, String title, String icon, String href, boolean spread, String target) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.href = href;
        this.spread = spread;
        this.target = target;
    }



    public TreeNode(Integer id, Integer pid, String title, String href, boolean spread, String target, List<TreeNode> children, String checkArr) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.href = href;
        this.spread = spread;
        this.target = target;
        this.children = children;
        this.checkArr = checkArr;
    }

    public TreeNode(Integer id, Integer pid, String title, Boolean spread, String checkArr) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
        this.checkArr = checkArr;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getCheckArr() {
        return checkArr;
    }

    public void setCheckArr(String checkArr) {
        this.checkArr = checkArr;
    }
}
