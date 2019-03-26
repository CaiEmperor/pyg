package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    /**
     * 查询所有品牌列表
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 查询分页所有品牌列表
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 根据条件分页查询
     * @param tbBrand
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult search(TbBrand tbBrand, int pageNum, int pageSize);
    /**
     * 添加品牌
     * @param tbBrand
     */
    void save(TbBrand tbBrand);

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    TbBrand findOne(Long id);

    /**
     * 更新品牌信息
     * @param tbBrand
     */
    void update(TbBrand tbBrand);

    /**
     * 批量删除品牌
     * @param ids
     */
    void delete(long[] ids);

    /**
     * 品牌下拉框数据
     * @return
     */
    List<Map> selectOptionList();
}
