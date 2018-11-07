/**
 * @name testApp Module
 * @description
 *
 */
'use strict';
angular.module('testApp',
		[ 'ui.router', 'ngStorage','ngResource', ]).config(
				function($stateProvider, $urlRouterProvider, $locationProvider) {
					
					$urlRouterProvider.otherwise('/home');
					
					$stateProvider
						.state('Home', {
						url : '/home',						
						views : {
							'headerView' : {
								templateUrl : 'header.html',
								controller : 'homeCtrl'
							},
							'mainView' : {
								templateUrl : 'home.html',
								controller : 'homeCtrl'
							}
						}
					});
					
			      $locationProvider.html5Mode({
			          enabled: true,
			          requireBase: false
			      });
					
				}).run([ '$state', function($state) {
					$state.transitionTo('Home');
				}
				]);
