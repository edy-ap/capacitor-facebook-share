import { WebPlugin } from '@capacitor/core';

import type { FacebookSharePlugin, ShareOptions, ShareResult } from './definitions';

export class FacebookShareWeb extends WebPlugin implements FacebookSharePlugin {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  sharePhoto(_options: ShareOptions): Promise<ShareResult>{
    throw new Error('Not supported in web');
    
  }

}
