angular.module('Geekstagram.user', [])
    .controller('userController', function($http, $location) {
        var self = this;
        var url = 'http://localhost:8081/api/';

        if (!localStorage.getItem('isConnected')) {
            $location.path('/login');
        }

        self.user = {
            name: localStorage.getItem('userName'),
            email: localStorage.getItem('userEmail'),
            password: localStorage.getItem('userPassword')
        };
        self.postList = [];

        /**
         * Aliette Ruppert
         * Update a user's data
         *
         * @param user
         */
        self.updateUser = function (user) {
            $http.put(url + 'users/' + localStorage.getItem('userId'), {
                name: user.name,
                password: user.password,
                email: user.email
            }).then(function (response) {
            }, function () {
                alert('An error occured');
            });
            user.updating = false;
        };

        /**
         * Aliette Ruppert
         * Get all posts
         */
        self.getAllPosts = function () {
            $http.get(url + 'posts/user/' + localStorage.getItem('userId')).then(function (response) {
                for (var i = 0; i < response.data.length; i++) {
                    response.data[i].editing = false;
                    self.postList.push(response.data[i]);
                }
            }, function () {
                alert('An error occured');
            });
        };

        /**
         * Aliette Ruppert
         * Update post's content
         *
         * @param post
         */
        self.updatePost = function (post) {
            $http.put(url + 'posts/' + post.id_post, { content_post: post.content }).then(function () {

            }, function () {
                alert('An error occured');
            });
            post.editing = false;
        };

        /**
         * Aliette Ruppert
         * @param post
         */
        self.deletePost = function (post) {
            $http.delete(url + 'posts/' + post.id_post);
            var index = self.postList.indexOf(post);

            if (index > -1) {
                self.postList.splice(index, 1);
            }
        }
    });
