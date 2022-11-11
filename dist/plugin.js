var capacitorFacebookShare = (function (exports, core) {
    'use strict';

    const FacebookShare = core.registerPlugin('FacebookShare', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.FacebookShareWeb()),
    });

    class FacebookShareWeb extends core.WebPlugin {
        // eslint-disable-next-line @typescript-eslint/no-unused-vars
        sharePhoto(_options) {
            throw new Error('Not supported in web');
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        FacebookShareWeb: FacebookShareWeb
    });

    exports.FacebookShare = FacebookShare;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
