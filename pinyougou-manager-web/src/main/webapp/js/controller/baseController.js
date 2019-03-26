app.controller("baseController", function ($scope) {
    //分页控件配置currentPage:当前页
    // totalItems :总记录数  itemsPerPage:每页记录数
    // perPageOptions :分页选项  onChange:当页码变更后自动触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 0,
        itemsPerPage: 10,
        perPageOptions: [5, 10, 15, 20, 25],
        onChange: function () {
            $scope.reloadList();
        }
    }
    //刷新列表
    $scope.reloadList = function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    //复选框
    $scope.selectIds = [];
    //更新复选
    $scope.updateSelection = function ($event, id) {
        //判断是否被选中
        if ($event.target.checked) {
            //加入到数组中
            $scope.selectIds.push(id);
        } else {
            //从数组中删除
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
    }
    //提取json字符串数据中某个属性，返回拼接字符串 逗号分隔
    $scope.jsonToString=function(jsonString,key){
        var json=JSON.parse(jsonString);//将json字符串转换为json对象
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=","
            }
            value+=json[i][key];
        }
        return value;
    }
});