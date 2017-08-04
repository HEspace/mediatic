'use strict';

describe('mediatic.version module', function() {
  beforeEach(module('mediatic.version'));

  describe('version service', function() {
    it('should return current version', inject(function(version) {
      expect(version).toEqual('0.1');
    }));
  });
});
