import { WebPlugin } from '@capacitor/core';
import type { FacebookSharePlugin, SharePhotoOptions, ShareResult, ShareVideoOptions } from './definitions';
export declare class FacebookShareWeb extends WebPlugin implements FacebookSharePlugin {
    sharePhoto(_options: SharePhotoOptions): Promise<ShareResult>;
    shareVideo(_options: ShareVideoOptions): Promise<ShareResult>;
}
