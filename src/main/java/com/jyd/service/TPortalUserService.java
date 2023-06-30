package com.jyd.service;

import java.util.List;

/**
 * 门户用户(TPortalUser)表服务接口
 *
 * @author makejava
 * @since 2023-06-30 16:16:49
 */
public interface TPortalUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPortalUser queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TPortalUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tPortalUser 实例对象
     * @return 实例对象
     */
    TPortalUser insert(TPortalUser tPortalUser);

    /**
     * 修改数据
     *
     * @param tPortalUser 实例对象
     * @return 实例对象
     */
    TPortalUser update(TPortalUser tPortalUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
