angular.module('Geekstagram.home', [])
    .controller('homeController', function($http, $location) {
        var self = this;
        // var url = 'http://localhost:8081/api/';
        self.postList = [];
        self.userList = [];
        self.content = '';

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
            });
        };

        /**
         * Aliette Ruppert
         * Get one user by its id
         *
         * @param id
         * @returns {*}
         */
        self.getUser = function(id) {

            for(var i = 0; i < self.userList.length; i++) {
                if (self.userList[i].id == id) {
                    return self.userList[i];
                }
            }
        };

        /**
         * Aliette Ruppert
         * Get all posts
         */
        self.getAllPosts = function() {
            $http.get(url + 'posts').
                then(function(response) {
                    self.postList = response.data;
                }, function() {
                    alert('An error occured');
                });
        };

        /**
         * Aliette Ruppert
         * Submit a new post
         */
        self.addNewPost = function() {
            if (!!self.content) {
                var post = { content_post: self.content };
                $http.post(url + 'posts/user/' + localStorage.getItem("userId"), post).
                then(function(response) {
                    self.postList.push(response.data);
                }, function() {
                    alert('An error occured');
                });
                self.content = '';
            }
        };
    });
