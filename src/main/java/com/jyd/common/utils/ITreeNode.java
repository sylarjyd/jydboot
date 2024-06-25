package com.jyd.common.utils;

import java.util.List;

/**
 * @Description: 固定属性结构属性
 * @Author: yiFei
 */
public interface ITreeNode<T> {
    /**
     * @return 获取当前元素Id
     */
    Object getId();

    /**
     * @return 获取父元素Id
     */
    Object getParentId();

    /**
     * @return 获取当前元素的 children 属性
     */
    List<T> getChildren();

    /**
     * ( 如果数据库设计有tree_path字段可覆盖此方法来生成tree_path路径 )
     *
     * @return 获取树路径
     */
    default Object getTreePath() { return ""; }
}
