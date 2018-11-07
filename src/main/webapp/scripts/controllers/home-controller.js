'use strict';

angular.module('testApp')
    .controller('homeCtrl',
        function ($scope, $state, $sessionStorage, LocatorService, $location, $log, $window) {

            $scope.search = function () {
                var formData = {
                    city: $scope.city,
                };
                $log.debug('$scope.city : ' + $scope.city);
                LocatorService.getDetailsByCity($scope.city).query().$promise.then(function (data) {			
        			$log.debug('success');
        			$scope.atmdetails = data;
        			$log.debug('success' + JSON.stringify($scope.results));
        		}, function (error) {
        			$log.debug(error);
        			$log.debug('error');
        		});

            };
            
            $scope.generalMeetingNav = function () {
                $state.go('agentGm', {}, {location: false});
            };
        });