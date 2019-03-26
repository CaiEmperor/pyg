//服务层
app.service("brandService", function ($http) {
    //查询所有品牌列表
    this.findAll=function () {
        return $http.get("../brand/findAll.do");
    }
    //分页查询所有品牌列表
    this.findPage=function (page, size) {
        return $http.get("../brand/findPage.do?page="+page+"&size="+size);
    }
    //条件分页查询
    this.search=function (page, size, searchEntity) {
        return $http.post("../brand/search.do?page="+page+"&size="+size, searchEntity);
    }
    //根据id查询
    this.findOne=function (id) {
        return $http.get("../brand/findOne.do?id="+id);
    }
    //保存品牌
    //1.没有id保存
    this.save=function (entity) {
        return $http.post("../brand/save.do", entity);
    }
    //2.有id更新
    this.update=function (entity) {
        return $http.post("../brand/update.do", entity);
    }
    //批量删除
    this.delete=function (ids) {
        return $http.get("../brand/delete.do?ids="+ids);
    }
    //下拉列表数据
    this.selectOptionList=function(){
        return $http.get('../brand/selectOptionList.do');
    }
});