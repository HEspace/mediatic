'use strict';

angular.module('mediatic.version', [
  'mediatic.version.interpolate-filter',
  'mediatic.version.version-directive'
])

.value('version', '0.1');
