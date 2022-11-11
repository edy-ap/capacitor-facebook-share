'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var core = require('@capacitor/core');

const FacebookShare = core.registerPlugin('FacebookShare', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.FacebookShareWeb()),
});

class FacebookShareWeb extends core.WebPlugin {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    sharePhoto(_options) {
        throw new Error('Not supported');
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    FacebookShareWeb: FacebookShareWeb
});

exports.FacebookShare = FacebookShare;
//# sourceMappingURL=plugin.cjs.js.map
