package com.jyd.service.impl;

import com.jyd.dao.TPortalUserDao;
import com.jyd.service.TPortalUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门户用户(TPortalUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-30 16:16:49
 */
@Service("tPortalUserService")
public class TPortalUserServiceImpl implements TPortalUserService {
    @Resource
    private TPortalUserDao tPortalUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TPortalUser queryById(String id) {
        return this.tPortalUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TPortalUser> queryAllByLimit(int offset, int limit) {
        return this.tPortalUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tPortalUser 实例对象
     * @return 实例对象
     */
    @Override
    public TPortalUser insert(TPortalUser tPortalUser) {
        this.tPortalUserDao.insert(tPortalUser);
        return tPortalUser;
    }

    /**
     * 修改数据
     *
     * @param tPortalUser 实例对象
     * @return 实例对象
     */
    @Override
    public TPortalUser update(TPortalUser tPortalUser) {
        this.tPortalUserDao.update(tPortalUser);
        return this.queryById(tPortalUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tPortalUserDao.deleteById(id) > 0;
    }
}
