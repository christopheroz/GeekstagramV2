'use strict';

var app = angular.module('Geekstagram', [
    'ngRoute',
    'Geekstagram.home',
    'Geekstagram.menu',
    'Geekstagram.signIn',
    'Geekstagram.user',
    'Geekstagram.searchUser'
]);

app.config(['$routeProvider',
    function($routeProvider) {
        // Système de routage
        $routeProvider
            .when('/', {
                templateUrl: 'views/home.html',
                controller: 'homeController',
                controllerAs: 'homeCtrl'
            })
            .when('/profil', {
                templateUrl: 'views/user_profile.html',
                controller: 'userController',
                controllerAs: 'userCtrl'
            })
            .when('/login', {
                templateUrl: 'views/signin.html',
                controller: 'signInController',
                controllerAs: 'signInCtrl'
            })
            .when('/user/:name', {
                templateUrl: 'views/search_result.html',
                controller: 'searchUserController',
                controllerAs: 'searchUserCtrl'
            })
    }
]);