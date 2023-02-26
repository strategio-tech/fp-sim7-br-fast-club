"use strict";

exports.__esModule = true;
exports["default"] = void 0;

var _propTypes = _interopRequireDefault(require("prop-types"));

var _react = _interopRequireDefault(require("react"));

var _loadGoogleMapsSdk = _interopRequireDefault(require("./loadGoogleMapsSdk"));

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { "default": obj }; }

function _inheritsLoose(subClass, superClass) { subClass.prototype = Object.create(superClass.prototype); subClass.prototype.constructor = subClass; subClass.__proto__ = superClass; }

var GoogleMapsLoader = /*#__PURE__*/function (_React$Component) {
  _inheritsLoose(GoogleMapsLoader, _React$Component);

  function GoogleMapsLoader() {
    var _this;

    _this = _React$Component.call(this) || this;
    _this._isMounted = false;
    _this.state = {
      googleMaps: null,
      error: null
    };
    return _this;
  }

  var _proto = GoogleMapsLoader.prototype;

  _proto.componentDidMount = function componentDidMount() {
    var _this2 = this;

    this._isMounted = true;
    var params = this.props.params;
    (0, _loadGoogleMapsSdk["default"])(params, function (_ref) {
      var googleMaps = _ref.googleMaps,
          error = _ref.error;
      return _this2._isMounted && _this2.setState({
        googleMaps: googleMaps,
        error: error
      });
    });
  };

  _proto.componentWillUnmount = function componentWillUnmount() {
    this._isMounted = false;
  };

  _proto.render = function render() {
    var _this$state = this.state,
        googleMaps = _this$state.googleMaps,
        error = _this$state.error;
    var render = this.props.render;
    return render(googleMaps, error);
  };

  return GoogleMapsLoader;
}(_react["default"].Component);

GoogleMapsLoader.propTypes = process.env.NODE_ENV !== "production" ? {
  params: _propTypes["default"].shape({
    key: _propTypes["default"].string.isRequired,
    libraries: _propTypes["default"].string
  }).isRequired,
  render: _propTypes["default"].func.isRequired
} : {};
var _default = GoogleMapsLoader;
exports["default"] = _default;
module.exports = exports.default;