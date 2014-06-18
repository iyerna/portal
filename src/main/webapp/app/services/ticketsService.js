//This handles retrieving data and is used by controllers. 3 options (server, factory, provider) with 
//each doing the same thing just structuring the functions/data differently.
app.service('ticketsService', function ($http, $q) {
    this.getTickets = function () {
    	// create a deferred object
    	var deferred = $q.defer();
    	$http.get('http://localhost:8180/ui/rest/tickets/').success(function(data) {
    		    // call resolve of deferred object to execute the success
    		    deferred.resolve(data);
    		  }).error(function(){
    		    // call reject of deferred object to execute failure
    		    deferred.reject();
    		  });
    	return deferred.promise;
    };
});