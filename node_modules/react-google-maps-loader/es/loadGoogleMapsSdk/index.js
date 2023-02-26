"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports["default"] = void 0;

var _littleLoader = _interopRequireDefault(require("little-loader"));

var _queryString = _interopRequireDefault(require("query-string"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { "default": obj }; }

var GOOGLE_MAP_PLACES_API = "https://maps.googleapis.com/maps/api/js";
var NOT_LOADED = 0;
var LOADING = 1;
var LOADED = 2;
var queue = [];
var state = NOT_LOADED;
var googleMaps = null;
var error = null;

function loadGoogleMapsSdk(params, callback) {
  if (typeof window !== "undefined") {
    window.gm_authFailure = function () {
      callback({
        googleMaps: googleMaps,
        error: "SDK Authentication Error"
      });
    };

    if (state === LOADED) {
      callback({
        googleMaps: googleMaps,
        error: error
      });
    } else if (state === LOADING) {
      queue.push(callback);
    } else if (window.google && window.google.maps) {
      state = LOADED;
      googleMaps = window.google.maps;
      callback({
        googleMaps: googleMaps,
        error: error
      });
    } else {
      state = LOADING;
      queue.push(callback);
      (0, _littleLoader["default"])(GOOGLE_MAP_PLACES_API + "?" + _queryString["default"].stringify(params), function (err) {
        state = LOADED;
        error = err ? "Network Error" : null;
        googleMaps = window.google ? window.google.maps : null;

        while (queue.length > 0) {
          queue.pop()({
            googleMaps: googleMaps,
            error: error
          });
        }
      });
    }
  }
}

var _default = loadGoogleMapsSdk;
exports["default"] = _default;