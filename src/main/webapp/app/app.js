/// <reference path="../Scripts/angular-1.1.4.js" />

/*#######################################################################
  
  Dan Wahlin
  http://twitter.com/DanWahlin
  http://weblogs.asp.net/dwahlin
  http://pluralsight.com/training/Authors/Details/dan-wahlin

  Normally like to break AngularJS apps into the following folder structure
  at a minimum:

  /app
      /controllers      
      /directives
      /services
      /partials
      /views

  #######################################################################*/

var app = angular.module('customersApp', []);

//This configures the routes and associates each route with a view and a controller
app.config(function ($routeProvider) {
    $routeProvider
    	.when('/login',
            {
                controller: 'LoginController',
                templateUrl: '/app/partials/login.html'
            })
        .when('/customers',
            {
                controller: 'CustomersController',
                templateUrl: '/app/partials/customers.html'
            })
        //Define a route that has a route parameter in it (:customerID)
        .when('/customertickets/:customerID',
            {
                controller: 'CustomerTicketsController',
                templateUrl: '/app/partials/customerTickets.html'
            })
        //Define a route that has a route parameter in it (:customerID)
        .when('/tickets',
            {
                controller: 'TicketsController',
                templateUrl: '/app/partials/tickets.html'
            })
        //Define a route that has a route parameter in it (:customerID)
        .when('/customerorders/:customerID',
            {
                controller: 'CustomerOrdersController',
                templateUrl: '/app/partials/customerOrders.html'
            })
        //Define a route that has a route parameter in it (:customerID)
        .when('/orders',
            {
                controller: 'OrdersController',
                templateUrl: '/app/partials/orders.html'
            })
        .otherwise({ redirectTo: '/customers' });
});




