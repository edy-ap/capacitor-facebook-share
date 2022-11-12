import { WebPlugin } from '@capacitor/core';

import type {
  FacebookSharePlugin,
  SharePhotoOptions,
  ShareResult,
  ShareVideoOptions,
} from './definitions';

export class FacebookShareWeb extends WebPlugin implements FacebookSharePlugin {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  sharePhoto(_options: SharePhotoOptions): Promise<ShareResult> {
    throw new Error('Not supported in web');
  }

  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  shareVideo(_options: ShareVideoOptions): Promise<ShareResult> {
    throw new Error('Not supported in web');
  }
}
