(function() {
  var ctrls = angular.module('controllers');
  ctrls.controller('TestMyTestCtrl', ['$scope', '$log','DialogService','DataService','MyUtilService', TestMyTestCtrl]);

  function TestMyTestCtrl($scope, $log,DialogService,DataService,MyUtilService) {
    $log.debug('TestMyTestCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('TestMyTestCtrl destroy...');
    });

    $scope.changePage = function(page) {
      $scope.demopage = 'templates/test/' + page + '.html';
    };

   DialogService.showWait('获取后台数据中...');
   DataService.send('/',{echo:new Date().getTime()},function(data){
     DialogService.hideWait();
     $scope.info=MyUtilService.trustAsHtml(MyUtilService.jsonSyntaxHighlight(MyUtilService.formatJson(JSON.stringify(data))));
   });
  }
})();
