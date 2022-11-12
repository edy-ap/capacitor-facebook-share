import { WebPlugin } from '@capacitor/core';
export class FacebookShareWeb extends WebPlugin {
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    sharePhoto(_options) {
        throw new Error('Not supported in web');
    }
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    shareVideo(_options) {
        throw new Error('Not supported in web');
    }
}
//# sourceMappingURL=web.js.map