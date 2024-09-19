export interface initParamOption {
    returnAdsEnabled?: boolean;
    isDev?: boolean;
    appId: String;
}

export interface GetResultString {
    result: String;
}

export interface StartioPlugin {
    initialize(options: initParamOption): Promise<void>;
    loadInterstitial(): Promise<GetResultString>;
    showInterstitial(): Promise<GetResultString>;
}
