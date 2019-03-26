package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 查询所有品牌列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    /**
     * 分页查询所有品牌列表
     * @param pageNum 当前页码
     * @param pageSize 每页记录条数
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam("page") int pageNum, @RequestParam("size") int pageSize){
        return brandService.findPage(pageNum, pageSize);
    }

    /**
     * 条件分页查询
     * @param tbBrand
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand, @RequestParam("page") int pageNum, @RequestParam("size") int pageSize){
        return brandService.search(tbBrand, pageNum, pageSize);
    }

    /**
     * 添加品牌
     * @param tbBrand
     */
    @RequestMapping("/save")
    public Result save(@RequestBody TbBrand tbBrand){
        try {
            brandService.save(tbBrand);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(long id){
            return brandService.findOne(id);
    }

    /**
     * 更新品牌
     * @param tbBrand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){
        try {
            brandService.update(tbBrand);
            return new Result(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更新失败");
        }
    }

    /**
     * 批量删除品牌
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "删除失败");
        }
    }

    /**
     * 品牌下拉框数据
     * @return
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}
