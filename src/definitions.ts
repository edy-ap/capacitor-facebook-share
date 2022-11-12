export interface FacebookSharePlugin {
  sharePhoto(options: SharePhotoOptions): Promise<ShareResult>;
  shareVideo(options: ShareVideoOptions): Promise<ShareResult>;
}

export interface ShareOptions {
  hashtags?: string;
  sharedMode?: 'automatic' | 'feed' | 'native' | 'web';
}

export interface SharePhotoOptions extends ShareOptions {
  data: any;
}

export interface ShareVideoOptions extends ShareOptions {
  path: string;
}

export interface ShareResult {
  success: boolean;
  message: string;
  /**
   * If available
   */
  postId: string;
}