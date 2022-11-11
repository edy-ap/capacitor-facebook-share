import { WebPlugin } from '@capacitor/core';
import type { FacebookSharePlugin, ShareOptions, ShareResult } from './definitions';
export declare class FacebookShareWeb extends WebPlugin implements FacebookSharePlugin {
    sharePhoto(_options: ShareOptions): Promise<ShareResult>;
}
