//This handles retrieving data and is used by controllers. 3 options (server, factory, provider) with 
//each doing the same thing just structuring the functions/data differently.
app.service('customersService', function ($http, $q) {
	this.getCustomers = function () {
    	// create a deferred object
    	var deferred = $q.defer();
    	$http.get('http://localhost:8180/ui/rest/customers/').success(function(data) {
    		    // call resolve of deferred object to execute the success
    		    deferred.resolve(data);
    		  }).error(function(){
    		    // call reject of deferred object to execute failure
    		    deferred.reject();
    		  });
    	return deferred.promise;
    };

    this.insertCustomer = function (firstName, lastName, email, userName) {
        var topID = customers.length + 1;
        customers.push({
            id: topID,
            firstName: firstName,
            lastName: lastName,
            email: email,
            userName: userName
        });
        var newCustomer = {id: topID, userName:'', firstName: firstName, lastName: lastName, email: email, userName: userName};
    	$http.put('http://localhost:8180/ui/rest/customers/create/', newCustomer).success(function(data) {
    		  });
    };

    this.deleteCustomer = function (id) {
        for (var i = customers.length - 1; i >= 0; i--) {
            if (customers[i].id === id) {
                customers.splice(i, 1);
                break;
            }
        }
    };

    this.getCustomer = function (id) {
        for (var i = 0; i < customers.length; i++) {
            if (customers[i].id === id) {
                return customers[i];
            }
        }
        return null;
    };

    var customers = [
        {
            id: 1, firstName: 'Lee', lastName: 'Carroll', email: 'carroll@test.com',
            tickets: [
                { id: '1', description: "Test Ticket 1", category: 'Billing Issue', created: '1/05/2014' },
                { id: '2', description: "Test Ticket 2", category: 'Billing Issue', created: '2/05/2014' },
                { id: '3', description: "Test Ticket 3", category: 'Billing Issue', created: '3/05/2014' }
            ]
        },
        {
            id: 2, firstName: 'Jesse', lastName: 'Hawkins', email: 'jesse@test.com',
            tickets: [
                { id: '4', description: "Test Ticket 4", category: 'General Issue', created: '4/05/2014' },
                { id: '5', description: "Test Ticket 5", category: 'General Issue', created: '5/05/2014' },
                { id: '6', description: "Test Ticket 6", category: 'General Issue', created: '30/04/2014' }
            ]
        },
        {
            id: 3, firstName: 'Charles', lastName: 'Sutton', email: 'charles@test.com',
            tickets: [
                      { id: '7', description: "Test Ticket 7", category: 'Product Issue', created: '29/04/2014' },
                      { id: '8', description: "Test Ticket 8", category: 'Product Issue', created: '26/04/2014' },
                      { id: '9', description: "Test Ticket 9", category: 'Product Issue', created: '25/04/2014' }
                  ]
        }
    ];

});