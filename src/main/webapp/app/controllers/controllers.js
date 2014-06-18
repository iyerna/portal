//This controller retrieves data from the customersService and associates it with the $scope
//The $scope is ultimately bound to the customers view
app.controller('CustomersController', function ($scope, customersService) {

    //I like to have an init() for controllers that need to perform some initialization. Keeps things in
    //one place...not required though especially in the simple example below
    init();

    function init() {
    	$scope.customers = [];
    	$scope.newCustomer = {firstName:'', lastName:'', email:'', userName:''};
    	customersService.getCustomers().then(function(data){
			      $scope.customers = data;
			    },
			    function(errorMessage){
			      $scope.error=errorMessage;
			    });
    }

    $scope.insertCustomer = function () {
        var firstName = $scope.newCustomer.firstName;
        var lastName = $scope.newCustomer.lastName;
        var email = $scope.newCustomer.email;
        var userName = $scope.newCustomer.userName;
        customersService.insertCustomer(firstName, lastName, email, userName);
        $scope.newCustomer.firstName = '';
        $scope.newCustomer.lastName = '';
        $scope.newCustomer.email = '';
        $scope.newCustomer.userName = '';
    };

    $scope.deleteCustomer = function (id) {
        customersService.deleteCustomer(id);
    };
});

//This controller retrieves data from the customersService and associates it with the $scope
//The $scope is bound to the order view
app.controller('CustomerTicketsController', function ($scope, $routeParams, customersService) {
    $scope.customer = {};

    //I like to have an init() for controllers that need to perform some initialization. Keeps things in
    //one place...not required though especially in the simple example below
    init();

    function init() {
        //Grab customerID off of the route        
        var customerID = ($routeParams.customerID) ? parseInt($routeParams.customerID) : 0;
        if (customerID > 0) {
            $scope.customer = customersService.getCustomer(customerID);
        }
    }

});

app.controller('LoginController', function ($scope, $routeParams) {
 
	init();
    function init() {
    }

});

//This controller retrieves data from the customersService and associates it with the $scope
//The $scope is bound to the orders view
app.controller('TicketsController', function ($scope, ticketsService) {
    $scope.tickets = [];
    //I like to have an init() for controllers that need to perform some initialization. Keeps things in
    //one place...not required though especially in the simple example below
    init();
    function init() {
    		ticketsService.getTickets().then(function(data){
    			      $scope.tickets = data;
    			    },
    			    function(errorMessage){
    			      $scope.error=errorMessage;
    			    });
        };
});

app.controller('NavbarController', function ($scope, $location) {
    $scope.getClass = function (path) {
        if ($location.path().substr(0, path.length) == path) {
            return true
        } else {
            return false;
        }
    }
});

//This controller is a child controller that will inherit functionality from a parent
//It's used to track the orderby parameter and ordersTotal for a customer. Put it here rather than duplicating 
//setOrder and orderby across multiple controllers.
app.controller('TicketChildController', function ($scope) {
    $scope.orderby = 'created';
    $scope.reverse = false;
    init();

    function init() {
    }

    $scope.setOrder = function (orderby) {
        if (orderby === $scope.orderby)
        {
            $scope.reverse = !$scope.reverse;
        }
        $scope.orderby = orderby;
    };

});