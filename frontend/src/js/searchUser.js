angular.module('Geekstagram.searchUser', [])
    .controller('searchUserController', function($location, $routeParams, $http) {
        var self = this;
        var url = 'http://localhost:8081/api/';
        self.user = false;
        self.notFound = false;
        self.userList = [];
        self.postList = [];

        if (!localStorage.getItem('isConnected')) {
            $location.path('/login');
        }

        /**
         * Aliette Ruppert
         * Get all the users' app
         */
        self.getUsers = function() {
            $http.get(url + 'users').
            then(function(response) {
                self.userList = response.data;
                for (var i = 0; i < self.userList.length; i++) {
                    if (self.userList[i].name == $routeParams.name) {
                        self.user = self.userList[i];
                    }
                }

                if (!self.user) {
                    self.notFound = true;
                }

                return self.user;
            }).
            then(function(user) {
                $http.get(url + 'posts/user/' + user.id).then(function (response) {
                    self.postList = response.data
                });
            })
        };
    });
