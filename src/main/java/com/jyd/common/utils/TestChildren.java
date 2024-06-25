package com.jyd.common.utils;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 测试子元素工具类
 * @Author: yiFei
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
public class TestChildren implements ITreeNode<TestChildren> {

    private Long id;

    private String name;

    private String treePath;

    private Long parentId;

    public TestChildren(Long id, String name, String treePath, Long parentId) {
        this.id = id;
        this.name = name;
        this.treePath = treePath;
        this.parentId = parentId;
    }

    @TableField(exist = false)
    private List<TestChildren> children = new ArrayList<>();


    public static void main(String[] args) {
        List<TestChildren> testChildren = new ArrayList<>();
        testChildren.add(new TestChildren(1L, "父元素", "", 0L));
        testChildren.add(new TestChildren(2L, "子元素1", "1", 1L));
        testChildren.add(new TestChildren(3L, "子元素2", "1", 1L));
        testChildren.add(new TestChildren(4L, "子元素2的孙子元素", "1,3", 3L));

        testChildren = TreeNodeUtil.buildTree(testChildren);

        System.out.println(JSONUtil.toJsonStr(testChildren));
    }
}
