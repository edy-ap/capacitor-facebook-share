export interface FacebookSharePlugin {
    sharePhoto(options: ShareOptions): Promise<ShareResult>;
}
export interface ShareOptions {
    data: any;
    hashtags: string;
}
export interface ShareResult {
    success: boolean;
    message: string;
}
