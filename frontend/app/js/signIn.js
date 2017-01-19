angular.module('Geekstagram.signIn', [])
    .controller('signInController', function($location, $rootScope, $http) {
        var self = this;
        // var url = 'http://localhost:8081/api/';
        // var url = 'http://172.20.10.12:8081/api/';
        self.message = null;
        self.allRight = false;

        self.login = function(email, password) {
          console.log(email,password);
          var user_send = { email: email, password: password };
            $http.post(url + 'users/connect', user_send)
                .then(function(response) {
                    var user = response.data;
                    console.log(user);
                    localStorage.setItem("userName", user.name);
                    localStorage.setItem("userId", user.id);
                    localStorage.setItem("userEmail", user.email);
                    localStorage.setItem("userToken", user.token);
                    localStorage.setItem("isConnected", true);
                    $rootScope.$emit('initUserConnection');
                    $location.path('/');
                });
        };

        self.signup = function(name, email, password) {
            $http.post(url + 'users', { name: name, email: email, password: password })
                .then(function() {
                    self.message = 'Votre compte à bien été créé ! Vous pouvez maintenant vous connecter.';
                    self.allRight = true;
                }, function() {
                    self.message = 'Une erreur est survenue :(';
                })
        };
    });
