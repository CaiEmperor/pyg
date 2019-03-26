//控制层
app.controller("brandController", function ($scope, $controller, brandService) {
    //伪继承
    $controller('baseController',{$scope:$scope});
    //查询所有品牌列表,读取列表数据绑定到表单中
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }
    //分页查询所有品牌列表
    $scope.findPage = function (page, size) {
        brandService.findPage(page, size).success(
            function (response) {
                $scope.list = response.rows//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }
    //定义搜索对象
    $scope.searchEntity = {};
    //条件分页查询
    $scope.search = function (page, size) {
        brandService.search(page, size, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }
    //保存品牌:1.先根据id查询品牌,2.在添加品牌
//1.根据id查询品牌
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        );
    }
//2.添加品牌
    $scope.save = function () {
        var serviceObject;//服务层对象
        if ($scope.entity.id != null) {
            serviceObject = brandService.update($scope.entity);
        } else {
            serviceObject = brandService.save($scope.entity);
        }
        serviceObject.success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        );
    }
    //批量删除品牌:1.选中id的集合,2.批量删除品牌
    //2.批量删除品牌
    $scope.delete = function () {
        if (confirm('确定要删除吗？')) {
            //获取选中的复选框
            brandService.delete($scope.selectIds).success(
                function (response) {
                    if (response.success) {
                        $scope.reloadList();
                        $scope.selectIds=[];
                    } else {
                        alert(response.message);
                    }

                }
            );
        }
    }
});
