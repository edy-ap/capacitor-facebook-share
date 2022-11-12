export interface FacebookSharePlugin {
  sharePhoto(options: SharePhotoOptions): Promise<ShareResult>;
  shareVideo(options: ShareVideoOptions): Promise<ShareResult>;
}

export interface SharePhotoOptions {
  data: any;
  hashtags?: string;
  /**
   * Only iOS: feedWeb, feedBrowser, shareSheet
   */
  sharedMode?:
    | 'automatic'
    | 'feed'
    | 'native'
    | 'web'
    | 'feedWeb'
    | 'feedBrowser'
    | 'shareSheet';
}

export interface ShareVideoOptions {
  path: string;
  hashtags?: string;
  /**
   * Only iOS: feedWeb, feedBrowser, shareSheet
   */
  sharedMode?:
    | 'automatic'
    | 'feed'
    | 'native'
    | 'web'
    | 'feedWeb'
    | 'feedBrowser'
    | 'shareSheet';
}

export interface ShareResult {
  success: boolean;
  message: string;
  /**
   * If available
   */
  postId: string;
}
