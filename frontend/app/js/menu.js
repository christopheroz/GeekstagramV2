angular.module('Geekstagram.menu', [])
    .controller('menuController', function($location, $rootScope, $http) {
        var self = this;
        // var url = 'http://localhost:8081/api/';
        self.user = {};
        self.isConnected = false;
        self.userList = [];

        self.initUser = function() {
            self.user = {
                name: localStorage.getItem("userName"),
                id: localStorage.getItem("userId")
            };
            self.isConnected = localStorage.getItem("isConnected");
        };

        /**
         * Aliette Ruppert
         * Get all the users' app
         */
        self.getUsers = function() {
            $http.get(url + 'users').
            then(function(response) {
                self.userList = response.data;
            });
        };

        self.disconnect = function() {
            $http.post(url + '/users/disconect/' + localStorage.getItem("userId"), {});
            localStorage.removeItem("userName");
            localStorage.removeItem("userEmail");
            localStorage.removeItem("userId");
            localStorage.removeItem("isConnected");
            self.initUser();
            $location.path('/login');
        };

        self.searchUser = function(user) {
            $location.path('/user/' + user);
        };

        $rootScope.$on('initUserConnection', self.initUser);
    });
