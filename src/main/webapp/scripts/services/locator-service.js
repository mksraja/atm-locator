(function () {
    'use strict';

angular.module('testApp')
        .factory('LocatorService', ['$http', '$localStorage', '$sessionStorage','$resource', '$log', function ($http, $localStorage, $sessionStorage, $resource, $log) {
        	
        return {
               getDetailsByCity: function (city) {
            	    $log.debug('city in the service : ' + city);
                    return $resource('api/locator/' + city + '/atms', {}, {
                           query: {method : "GET", isArray:true}
                           });
               }
        };
    }
]);

})();