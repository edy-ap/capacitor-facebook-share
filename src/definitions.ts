export interface FacebookSharePlugin {
  sharePhoto(options: ShareOptions): Promise<void>;
}

export interface ShareOptions {
  data: any;
  hashtags: string;
}