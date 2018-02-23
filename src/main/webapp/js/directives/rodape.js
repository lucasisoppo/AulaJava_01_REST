'use strict';

angular.module('ngdemo.rodapeDirective', [])
    .directive('rodape', rodape);

/**
 * Directive rodape
 */

function rodape(){
  return {
    restrict:'EA',
    templateUrl:'partials/rodape.html'
  };
}
