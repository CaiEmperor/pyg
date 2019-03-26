package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 查询所有列表
     * @return
     */
    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    /**
     * 查询分页列表
     * @param pageNum 当前页码
     * @param pageSize 每页条数
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //分页参数
        PageHelper.startPage(pageNum, pageSize);
        //分页查询列表
        Page<TbBrand> tbBrandPage = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        return new PageResult(tbBrandPage.getTotal(), tbBrandPage.getResult());
    }

    /**
     * 根据条件分页查询
     * @param tbBrand
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult search(TbBrand tbBrand, int pageNum, int pageSize) {
        //分页参数
        PageHelper.startPage(pageNum, pageSize);
        //条件对象
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (tbBrand != null){
            if (tbBrand.getName() != null && tbBrand.getName().length() > 0){
                criteria.andNameLike("%"+tbBrand.getName()+"%");
            }
            if(tbBrand.getFirstChar()!=null && tbBrand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
            }
        }
        //分页查询列表
        Page<TbBrand> tbBrandPage = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
        return new PageResult(tbBrandPage.getTotal(), tbBrandPage.getResult());
    }

    /**
     * 添加品牌
     * @param tbBrand
     */
    @Override
    public void save(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @Override
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    /**
     * 批量删除品牌
     * @param ids
     */
    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 列表数据
     * @return
     */
    @Override
    public List<Map> selectOptionList() {
        return tbBrandMapper.selectOptionList();
    }
}
