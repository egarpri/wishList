var app = angular.module('wishList', [ "ngResource" ]);

app.controller('WishController', [ '$scope', '$http',
                                     
	function($scope, $http) {
		$scope.getWishes = function() {
			$http.get('/wishes/list').success(function(data) {
				$scope.wishes = data;
			});
		}
		
		$scope.addWish = function() {
			$http.post('/wishes/add', 
				{
					title : $scope.title
				}
			).success(function(data) {
				$scope.msg = 'Wish added correctly';
				$scope.getWishes();
			}).error(function(data) {
				$scope.msg = 'Error';
			});
		}
		
		$scope.deleteWish = function() {
			$http.post('/wishes/delete', 
				{
					title : $scope.title
				}
			).success(function(data) {
				$scope.msg = 'Wish deleted correctly';
				$scope.getWishes();
			}).error(function(data) {
				$scope.msg = 'Error';
			});
		}
		
		$scope.searchWish = function() {
			$http.post('/wishes/search', 
				{
					title : $scope.title
				}
			).success(function(data) {
				$scope.msg = data.title;
				$scope.getWishes();
			}).error(function(data) {
				$scope.msg = 'Error';
			});
		}
} ]);