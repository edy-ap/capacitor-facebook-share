import { registerPlugin } from '@capacitor/core';
const FacebookShare = registerPlugin('FacebookShare', {
    web: () => import('./web').then(m => new m.FacebookShareWeb()),
});
export * from './definitions';
export { FacebookShare };
//# sourceMappingURL=index.js.map