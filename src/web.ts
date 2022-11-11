import { WebPlugin } from '@capacitor/core';

import type { FacebookSharePlugin, ShareOptions } from './definitions';

export class FacebookShareWeb extends WebPlugin implements FacebookSharePlugin {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  sharePhoto(_options: ShareOptions): Promise<void>{
    throw new Error('Not supported');
    
  }

}
